import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-game-search-results',
  templateUrl: './game-search-results.component.html',
  styleUrls: ['./game-search-results.component.css']
})
export class GameSearchResultsComponent implements OnInit {

  List;

  constructor() {
    this.List = [1,2,3,4];
   }

  ngOnInit() {
  }

}
