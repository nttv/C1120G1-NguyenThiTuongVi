import {Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-exercise-login',
  templateUrl: './exercise-login.component.html',
  styleUrls: ['./exercise-login.component.css']
})

export class ExerciseLoginComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }

  submit(loginForm: NgForm) {
    alert('Welcome back!\n' + loginForm.value.email);
    console.log(loginForm.value);
  }
}
