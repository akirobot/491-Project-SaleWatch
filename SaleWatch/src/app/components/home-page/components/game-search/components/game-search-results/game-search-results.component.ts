import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs/operators';

import { Game } from'../../../../../../models/Game';

import { GameService } from '../../../../../../services/game.service';

@Component({
  selector: 'app-game-search-results',
  templateUrl: './game-search-results.component.html',
  styleUrls: ['./game-search-results.component.css']
})
export class GameSearchResultsComponent implements OnInit {
  //Just a dummy variable to demonstrate multiple "Game Results"
  gameList: Game[];
  game_search_params: string

  constructor( 
    private route: ActivatedRoute,
    private router: Router,
    private gameService: GameService
    ) { }

  ngOnInit() {
    this.route.queryParams
      .subscribe(params => {
        this.game_search_params = params.search;
        this.gameService
          .searchGames(this.game_search_params)
          .pipe(first())
          .subscribe(
            data => {
              this.gameList = data as Game;
              // console.log(this.gameList); TESTING
            },
            error => {
              console.log(error);
            }
          )
        // console.log(this.game_search_params);
      });
  }

  moreInfo(Game) {
    let game = Game as Game;
    localStorage.setItem('currentGame', JSON.stringify(game));
    this.router.navigate(['/game-search-results/game-data']);
  }

}
