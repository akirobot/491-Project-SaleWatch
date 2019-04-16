import { Component, OnInit, AfterViewInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Observable, Subscription } from 'rxjs';

import { User } from '../../models/User.js';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  currentUser: User;
  currentUserSubscription: Subscription;

  constructor(
    private userService: UserService,
  ) { 
    this.currentUserSubscription = this.userService.currentUser$.subscribe(user => {
      this.currentUser = user;
    })
  }

  ngOnInit() { 
    console.log(this.currentUser);
  }

  ngOnDestroy() {
    this.currentUserSubscription.unsubscribe();
  }

}
