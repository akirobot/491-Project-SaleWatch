import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root'})
export class GameService {

    uri = 'http://localhost:4000/game';

    constructor(private http: HttpClient) { }

    searchGames(searchField) {
        const obj = {
            game_title: searchField
        };
        this.http.post(`${this.uri}/search`, obj)
            .subscribe(res => console.log('Search Complete'));
    }
}