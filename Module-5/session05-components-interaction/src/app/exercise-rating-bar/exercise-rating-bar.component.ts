import {Component, EventEmitter, Input, OnInit, Output, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-exercise-rating-bar',
  templateUrl: './exercise-rating-bar.component.html',
  styleUrls: ['./exercise-rating-bar.component.scss']
})
export class ExerciseRatingBarComponent implements OnInit {

  @Input('maxRating') max: number = 0;
  @Input('previousRating') ratingValue: number = 0;
  @Input('showRating') showRatingValue: boolean = false;

  ratingUnits: IRatingUnit[] = [];

  constructor() {
  }

  ngOnInit() {
    this.init();
  }

  init() {
    this.ratingUnits = Array.from({length: this.max},
      (_, index) => ({
        value: index + 1,
        active: index < this.ratingValue
      }));
  }

  select(index) {
    this.ratingValue = index + 1;
    this.ratingUnits.forEach((item, idx) => item.active = idx < this.ratingValue);
  }

  enter(index) {
    this.ratingUnits.forEach((item, idx) => item.active = idx <= index);
  }

  reset() {
    this.ratingUnits.forEach((item, idx) => item.active = idx < this.ratingValue);
  }

}

interface IRatingUnit {
  value: number;
  active: boolean;
}
