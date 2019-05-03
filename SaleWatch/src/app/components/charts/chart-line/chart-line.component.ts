import { Component, OnInit } from '@angular/core';
/*var assert = require('assert');
var mongo = require('mongod');
var express = require('express');
var router = express.Router();*/

var url = 'mongodb://localhost:27017/admin';

@Component({
  selector: 'app-chart-line',
  templateUrl: './chart-line.component.html',
  styleUrls: ['./chart-line.component.css']
})

 
export class ChartLineComponent implements OnInit {

 

  /*
  mygame = {price: 12, days: 12, release: 123}; //CODED OUT UNTIL I GET DATA
  */

  points: number;
  today = new Date('2019-04-21T03:24:00');
  //var array_name[:datatype];        //declaration 
  array_name = [3,100,50,2,100,4,100,7,100];

  
  public lineChartData: any[] = [
    { data: [this.array_name[1], this.array_name[2],this.array_name[3], this.array_name[4], this.array_name[5],
       this.array_name[6], this.array_name[7],this.array_name[8], this.array_name[9], this.array_name[10], this.array_name[11], this.array_name[12]], label: 'Price' },
  ];
  public lineChartLabels: any[] = ['May', 'June', 'July', 'August', 'September', 'August', 'November'];
  public lineChartOptions: any = {
    responsive: true,
    maintainAspectRatio: false
  };
  public lineChartColors: any[] = [
    { // grey
      backgroundColor: 'rgba(148,159,177,0.2)',
      borderColor: 'rgba(148,159,177,1)',
      pointBackgroundColor: 'rgba(148,159,177,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(148,159,177,0.8)'
    },
    { // dark grey
      backgroundColor: 'rgba(77,83,96,0.2)',
      borderColor: 'rgba(77,83,96,1)',
      pointBackgroundColor: 'rgba(77,83,96,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(77,83,96,1)'
    },
    { // grey
      backgroundColor: 'rgba(148,159,177,0.2)',
      borderColor: 'rgba(148,159,177,1)',
      pointBackgroundColor: 'rgba(148,159,177,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(148,159,177,0.8)'
    }
  ];
  public lineChartLegend = true;
  public lineChartType = 'line';



  public predictor(price: number, days: number, changes: number, sign: number, holiday: Date): number {
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

  constructor() { }

  ngOnInit() {
  }
}