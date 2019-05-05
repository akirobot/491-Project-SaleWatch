import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

import { Game } from '../models/Game';

@Injectable({ providedIn: 'root'})
export class GameService {

    public games: Game;
    uri = 'http://localhost:4000/game';

    constructor(private http: HttpClient) { }

    searchGames(searchField) {
        const obj = {
            game_title: searchField
        };
        return this.http.post(`${this.uri}/search`, obj)
            .pipe(map(game => {
                if (game) {
                    this.games = game as Game[];
                    return this.games;
                }
            }))
            // .subscribe(res => console.log('Search Complete'));
    }

    getGames() {
        return this.http.get(`${this.uri}/get`)
            .pipe(map(game => {
                if (game) {
                    this.games = game as Game;
                    return this.games;
                }
            }))
    }
}