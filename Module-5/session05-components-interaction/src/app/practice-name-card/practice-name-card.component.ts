import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-practice-name-card',
  templateUrl: './practice-name-card.component.html',
  styleUrls: ['./practice-name-card.component.scss']
})
export class PracticeNameCardComponent implements OnInit {

  @Input() cardName: string;
  @Input() email: string;
  @Input() phone: string;

  constructor() { }

  ngOnInit(): void {
  }

}
