import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-practice-font-size-editor',
  templateUrl: './practice-font-size-editor.component.html',
  styleUrls: ['./practice-font-size-editor.component.css']
})
export class PracticeFontSizeEditorComponent implements OnInit {

  fontSize1 = 14;
  fontSize2 = 14;

  constructor() {
  }

  ngOnInit(): void {
  }

  changeFontSizeValue(fontSize) {
    this.fontSize1 = fontSize;
  }

}
