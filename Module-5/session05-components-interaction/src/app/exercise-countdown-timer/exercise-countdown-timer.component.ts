import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-exercise-countdown-timer',
  templateUrl: './exercise-countdown-timer.component.html',
  styleUrls: ['./exercise-countdown-timer.component.scss']
})
export class ExerciseCountdownTimerComponent implements OnInit {

  intervalId: number;
  message: string = '';
  remainingTime: number;

  @Input('myTimer') seconds = 10;

  ngOnInit() {
    this.reset();
  }

  clearTimer() {
    clearInterval(this.intervalId);
  }

  start() {
    this.clearTimer();
    this.intervalId = window.setInterval(() => {
      this.remainingTime--;
      if (this.remainingTime === 0) {
        this.message = 'Time out!';
        this.clearTimer();
      } else {
        this.message = `T-${this.remainingTime} seconds and counting`;
      }
    }, 1000);
    if (this.remainingTime <= 0) {
      this.remainingTime = this.seconds;
    }
  }

  stop() {
    this.clearTimer();
    this.message = `Pausing at T-${this.remainingTime} seconds`;
  }

  reset() {
    this.clearTimer();
    this.remainingTime = this.seconds;
    this.message = `Click start button to start the Countdown`;
  }
}
