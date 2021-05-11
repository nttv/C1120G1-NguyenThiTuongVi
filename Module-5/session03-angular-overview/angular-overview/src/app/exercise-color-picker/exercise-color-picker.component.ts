import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-exercise-color-picker',
  templateUrl: './exercise-color-picker.component.html',
  styleUrls: ['./exercise-color-picker.component.css']
})
export class ExerciseColorPickerComponent implements OnInit {

  color: string = "black";

  constructor() {
  }

  ngOnInit(): void {
  }

  pickColor(color: string) {
    this.color = color;
  }

}
