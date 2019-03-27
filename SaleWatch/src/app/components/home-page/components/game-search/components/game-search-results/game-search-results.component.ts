import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { GameService } from '../../../../../../services/game.service';

@Component({
  selector: 'app-game-search-results',
  templateUrl: './game-search-results.component.html',
  styleUrls: ['./game-search-results.component.css']
})
export class GameSearchResultsComponent implements OnInit {
  //Just a dummy variable to demonstrate multiple "Game Results"
  List;
  game_search_user: string

  constructor( 
    private route: ActivatedRoute,
    private gameService: GameService
    ) {
    this.List = [1,2,3,4];
   }

  ngOnInit() {
    this.route.queryParams
      .subscribe(params => {
        console.log(params);
        this.game_search_user = params.search;
        this.gameService.searchGames(this.game_search_user);
        console.log(this.game_search_user);
      });
  }

}
