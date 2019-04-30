import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../../services/user.service';
import { User } from '../../../../models/user';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  list = [1, 3, 4, 5];
  currentUser: User;
  currentUserSubscription: Subscription;

  constructor(
    private userService: UserService
  ) {
    this.currentUserSubscription = this.userService.currentUser$.subscribe(data => {
      this.currentUser = data;
    })
   }

  ngOnInit() {
    
  }

  ngOnDestroy() {
    this.currentUserSubscription.unsubscribe();
  }

}
