import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  loading = false;
  submitted = false;

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private userService: UserService
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

    if(this.registerForm.invalid) {
      return;
    }

    this.loading = true;
    this.userService.register(this.f.user_first_name.value, this.f.user_last_name.value, this.f.user_email.value, this.f.user_password.value);
    this.loading = false;
  }

  get f() {
    return this.registerForm.controls;
  }

}
