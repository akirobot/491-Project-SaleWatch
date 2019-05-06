import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs/operators';

import { UserService } from 'src/app/services/user.service';

import { User } from '../../../../models/User.js';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  users: User[];

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService,
  ) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      user_email: ['', Validators.required],
      user_password: ['', Validators.required]
    });
  }

  login() {
    this.submitted = true;

    if(this.loginForm.invalid) {
      return;
    }

    this.loading = true;
    this.userService
      .login(this.f.user_email.value, this.f.user_password.value)
      .pipe(first())
      .subscribe(
        data => {
          if(localStorage.getItem("currentUser")) {
            this.router.navigate(['/']);
          }
          else {
            this.f.user_email.setValue("Incorrect Email or Password");
            this.f.user_password.setValue("");
            this.loading = false;
          }
        },
        error => {
          console.log(error);
          this.loading = false;
        }
      )
  }

  get f() { 
    return this.loginForm.controls; 
  }

}
