import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-practice-progress-bar',
  templateUrl: './practice-progress-bar.component.html',
  styleUrls: ['./practice-progress-bar.component.scss']
})
export class PracticeProgressBarComponent implements OnInit {

  @Input() backgroundColor = '#D9D9D9';
  @Input() progressColor = '#4CAF50';
  @Input() progress = 0;

  constructor() {
  }

  ngOnInit(): void {
    this.loading();
  }

  loading() {
    let interval = setInterval(() => {
      this.progress = +this.progress + 5;
      if (this.progress == 100) {
        clearInterval(interval);
      }
    }, 1000);
  }

}
