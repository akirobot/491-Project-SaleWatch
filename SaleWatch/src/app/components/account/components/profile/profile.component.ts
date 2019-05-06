import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDatepicker } from '@angular/material';
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
  editProfile: boolean;
  editForm: FormGroup;
  submitted = false;

  constructor(
    private userService: UserService,
    private router: Router,
    private formBuilder: FormBuilder
  ) {
    this.currentUserSubscription = this.userService.currentUser$.subscribe(data => {
      this.currentUser = data;
    })
   }

  ngOnInit() {
    this.editProfile = false;
    this.editForm = this.formBuilder.group({
      user_birthday: ['', Validators.required],
      user_favorite_game_genre: ['', Validators.required]
    })
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

  edit() {
    if(this.editProfile) {
      this.editProfile = false;
    }
    else {
      this.editProfile = true;
    }
  }

  save() {
    this.submitted = true;
    if(this.editForm.invalid) {
      return;
    }
    this.currentUser.user_birthday = this.f.user_birthday.value;
    this.currentUser.user_favorite_game_genre = this.f.user_favorite_game_genre.value;
    this.userService.save(this.currentUser);
    this.editProfile = false;
  }

  get f() {
    return this.editForm.controls;
  }

}
