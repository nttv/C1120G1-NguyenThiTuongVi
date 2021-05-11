import {Component, OnInit} from '@angular/core';
import {Pet} from "./model/pet";

@Component({
  selector: 'app-practice-pet',
  templateUrl: './practice-pet.component.html',
  styleUrls: ['./practice-pet.component.css']
})
export class PracticePetComponent implements OnInit {

  pet: Pet = {
    name: 'puppie',
    image: 'http://yourdost-blog-images.s3-ap-southeast-1.amazonaws.com/wp-content/uploads/2016/01/03165939/Dogs.jpg'
  };

  constructor() {
  }

  ngOnInit(): void {
  }

}
