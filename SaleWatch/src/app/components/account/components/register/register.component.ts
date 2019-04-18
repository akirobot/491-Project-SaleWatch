import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs/operators';

import { UserService } from 'src/app/services/user.service';

import { User } from '../../../../models/User.js';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  loading = false;
  submitted = false;
  users: User;
  userExists: boolean;

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      user_first_name: ['', Validators.required],
      user_last_name: ['', Validators.required],
      user_email: ['', Validators.required],
      user_password: ['', Validators.required]
    });

    //Check to see if User is already logged in... Use local storage... in User.Service
  }

  register() {
    this.submitted = true;
    this.userExists = false;
    if(this.registerForm.invalid) {
      return;
    }
    this.loading = true;
    this.userService.getAllUsers()
      .pipe(first())
      .subscribe(
        data => {
          let users = data as User;
          users.forEach(u => {
            if(u.user_email == this.f.user_email.value) {
              this.userExists = true;
              this.loading = false;
              return;
            }
          });
          if(!this.userExists) {
            this.userService.register(this.f.user_first_name.value, this.f.user_last_name.value, this.f.user_email.value, this.f.user_password.value);
            this.loading = false;
            this.router.navigate(['/']);
          }
          this.loading = false;
        },
        error => {
          console.log(error);
          this.loading = false;
        }
      )
  }

  get f() {
    return this.registerForm.controls;
  }

}
