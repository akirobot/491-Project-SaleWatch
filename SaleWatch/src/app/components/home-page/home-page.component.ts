import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatMenu } from '@angular/material';
import { GameService } from '../../services/game.service';
import { first } from 'rxjs/operators';

import { Game } from '../../models/game';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  gameList: Game[];
  games: Game[];
  menuList: string[];
  
  constructor(
    private gameService: GameService,
    private router: Router
  ) {
    this.gameList = new Array<Game>();
    this.menuList = [ "Action", "Adventure", "Casual", "Indie", "Racing", "RPG", "Sports", "Strategy" ];
   }

  ngOnInit() {
    this.gameService.getGames()
      .pipe(first())
      .subscribe(
        data => {
          this.games = data as Game;
          this.home();
        }
      )
  }

  moreInfo(Game) {
    let game = Game as Game;
    localStorage.setItem('currentGame', JSON.stringify(game));
    this.router.navigate(['/game-search-results/game-data']);
  }

  home() {
    this.gameList = new Array<Game>();
    for(let i = 0; i < 6; i++) {
      if(this.games[i]) {
        this.gameList.push(this.games[i]);
      }
    }
  }

  topSavings() {
    if(this.games) {
      let g = this.games.slice();
      let index = 0;
      let x = 0;
      
      for(let i = 0; i < this.gameList.length; i++) {

        if(g.length > 1) {
          let test = g.reduce((max, game) => {
            let maxP = max.price as string;
            let gameP = game.price as string;
            let maxS = max.sale_price as string;
            let gameS = game.sale_price as string;
    
            maxP = maxP.replace("$","");
            maxS = maxS.replace("$","");
            gameP = gameP.replace("$","");
            gameS = gameS.replace("$","");
    
            let maxPrice = parseFloat(maxP);
            let maxSPrice = parseFloat(maxS);
            let gamePrice = parseFloat(gameP);
            let gameSPrice = parseFloat(gameS);
            let maxDif = maxPrice - maxSPrice;
            let gameDif = gamePrice - gameSPrice;
    
            x++;
            // return maxDif > gameDif ? max : game;
            if(maxDif > gameDif) {
              return max;
            } else {
              index = x;
              return game;
            }
          })
          this.gameList[i] = test;
          g.splice(index, 1);
          index = 0;
          x = 0;  
        }
        else {
          this.gameList[i] = g[0];
        }

      }//for

    }
  }

  categories(category) {
    if(this.games) {
      let index = 0;
      this.games.forEach(g => {

        for(let i = 0; i < g.user_tags.length; i++) {
          if(g.user_tags[i] == category) {
            this.gameList[index] = g;
            index++;
            break;
          }
        }
        if(index > 5) {
          console.log(this.gameList);
          return;
        }
      });
    }
  }
  
  comingSoon() {
    console.log("coming soon...");
  }

}