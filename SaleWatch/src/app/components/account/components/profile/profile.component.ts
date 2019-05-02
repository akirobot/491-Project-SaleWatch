import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../../../services/user.service';
import { Game } from '../../../../models/game'
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
    private userService: UserService,
    private router: Router
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

  moreInfo(Game) {
    let game = Game as Game;
    localStorage.setItem('currentGame', JSON.stringify(game));
    this.router.navigate(['/game-search-results/game-data']);
  }

  removeGame(Game) {
    for(var i = 0; i < this.currentUser.user_games.length; i++) {
      if(this.currentUser.user_games[i] == Game) {
        this.currentUser.user_games.splice(i,1);
        this.userService.save(this.currentUser);
      }
    }
  }

}
