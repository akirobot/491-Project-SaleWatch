import { Component, OnInit } from '@angular/core';
import { Subscription, Observable, BehaviorSubject } from 'rxjs';

import { UserService } from '../../../../../../services/user.service';

import { Game } from '../../../../../../models/Game';
import { User } from '../../../../../../models/User';

@Component({
  selector: 'app-game-data',
  templateUrl: './game-data.component.html',
  styleUrls: ['./game-data.component.css']
})
export class GameDataComponent implements OnInit {

  currentGame: Game;
  currentGameSubscription: Subscription;
  currentGameGenre: String;
  game$: Observable<Game>;
  gameSubject$: BehaviorSubject<Game>;
  currentUser: User;
  currentUserSubscription: Subscription;
  test: String[];

  constructor(
    private userService: UserService,
  ) { 
    this.gameSubject$ = new BehaviorSubject<Game>(JSON.parse(localStorage.getItem("currentGame")));
    this.game$ = this.gameSubject$.asObservable();

    this.currentGameSubscription = this.game$.subscribe(data => {
      this.currentGame = data;
      this.currentGameGenre = data.user_tags[0];
    })
    this.currentUserSubscription = this.userService.currentUser$.subscribe(data => {
      this.currentUser = data;
    })
  }

  ngOnInit() { }

  ngOnDestroy() {
    this.currentGameSubscription.unsubscribe();
    this.currentUserSubscription.unsubscribe();
  }

  bookmark() {
    this.currentUser.user_games.push(this.currentGame);
    this.userService.save(this.currentUser);
  }
}


