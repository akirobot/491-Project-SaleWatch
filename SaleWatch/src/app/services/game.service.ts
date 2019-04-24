import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root'})
export class GameService {

    uri = 'http://localhost:4000/game';
    constructor(private http: HttpClient) { }
    points: number;
    today = new Date('2019-04-21T03:24:00');
    //var array_name[:datatype];        //declaration 
    array_name = [];
     

    searchGames(searchField) {
        const obj = {
            game_title: searchField
        }; 
        this.http.post(`${this.uri}/search`, obj)
            .subscribe(res => console.log('Search Complete'));
    }

    //THE RETURNED OBJECTED FROM THIS IS NEEDED SO I CAN APRSE INTO SPECIFIC INFORMATION

    predictor(price: number, days: number, changes: number, sign: number, holiday: Date): number {
        //const points = 0;
        var temp = price;
        var sign = 0;
        var discount = 0;
        var best = 100.00;
        sign = sign + 0;

        if (price >= 59.99){
            this.points=1;
        }
        if (price < 59.99 && price >= 54.99){
            this.points=2;
        }
        if (price < 54.99 && price >= 49.99){
            this.points=3;
        } 
        if (price < 49.99 && price >= 44.99){
            this.points=4;
        }    
        if (price < 44.99 && price >= 39.99){
            this.points=5;
        } 
        if (price < 39.99 && price >= 34.99){
            this.points=6;
        } 
        if (price < 34.99 && price >= 24.99){
            this.points=7;
        }
        if (price < 24.99 && price >= 19.99){
            this.points=8;
        }
        if (price < 19.99 && price >= 17.99){
            this.points=9;
        }
        if (price < 17.99 && price >= 15.99){
            this.points=10;
        } 
        if (price < 15.99 && price >= 13.99){
            this.points=12;
        } 
        if (price < 13.99 && price >= 11.99){
            this.points=14;
        } 
        if (price < 11.99 && price >= 9.99){
            this.points=16;
        } 
        if (price < 9.99 && price >= 8.99){
            this.points=18;
        } 
        if (price < 8.99 && price >= 7.99){
            this.points=20;
        } 
        if (price < 7.99 && price >= 6.99){
            this.points=24;
        } 
        if (price < 6.99 && price >= 5.99){
            this.points=28;
        } 
        if (price < 5.99 && price >= 4.99){
            this.points=30;
        } 
        if (price < 4.99 && price >= 3.99){
            this.points=34;
        } 
        if (price < 3.99 && price >= 3.49){
            this.points=38;
        } 
        if (price < 3.49 && price >= 2.99){
            this.points=42;
        } 
        if (price < 2.99 && price >= 2.49){
            this.points=50;
        } 
        if (price < 2.49 && price >= 1.99){
            this.points=58;
        } 
        if (price < 1.99 && price >= 0.99){
            this.points=66;
        } 
        ///////////////////////////////////////////////////////
        var mon = new Date("2019-04-20T12:01:04.753Z");
        var time = holiday.getTime() - new Date("2019-04-20T12:01:04.753Z").getTime()//JUST USING TODAYS DATE FOR THE TIME BEING
        time = time/1000;
        time = time/60;
        time = time/60;
        time = time/24;

        if (time < 90){
            this.points = this.points + 1;
        }
        if (time < 180 && time >= 90){
            this.points = this.points + 2;
        }
        if (time < 270 && time >= 180){
            this.points = this.points + 3;
        }
        if (time < 360 && time >= 270){
            this.points = this.points + 4;
        }
        if (time < 400 && time >= 360){
            this.points = this.points + 6;
        }
        if (time < 440 && time >= 400){
            this.points = this.points + 8;
        }
        if (time < 480 && time >= 440){
            this.points = this.points + 10;
        }
        if (time < 500 && time >= 480){
            this.points = this.points + 11;
        }
        if (time < 550 && time >= 500){
            this.points = this.points + 13;
        }
        if (time < 600&& time >= 550){
            this.points = this.points + 15;
        }
        if (time > 600){
            this.points = this.points + 17;
        }
        /////////////////////////////////////////////////

        while(this.points > 50){
            this.points = this.points - 50;
            
        }
        if (this.points%2 == 0){
            sign = 2;
        }
        else{
            sign = 0;
        }

        while(this.points > 10){
            this.points = this.points/2;
        }

        for(var i =0; i < 12; i++){
            discount = (temp/100) * this.points;
            if(sign >= 1){ //price going down
                temp = temp - discount;
            }
            else{  //Price going up
                temp = temp + discount;
            }
            
            if (mon.getMonth() == 1 || mon.getMonth() == 2 || mon.getMonth() == 5 ||mon.getMonth() == 9 || mon.getMonth() == 10){
                sign = sign +1;
                this.points = this.points + 2;
                mon.getMonth() == mon.getMonth() + 1;

            }
            else{
                sign = sign - 1;
                this.points = this.points +2;
                mon.getMonth() == mon.getMonth() + 1;
            }

            this.points = (this.points + 10 + i );
            while(this.points > 10){
                this.points = this.points/2;
            }

            this.array_name[i] = temp;

            if(best > temp){
                best = temp;
            }
        }
        
        
        
        
        return best;
    }
}