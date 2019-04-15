import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  list = [1, 3, 4, 5];
  constructor() {
    
   }

  ngOnInit() {
  }

}
