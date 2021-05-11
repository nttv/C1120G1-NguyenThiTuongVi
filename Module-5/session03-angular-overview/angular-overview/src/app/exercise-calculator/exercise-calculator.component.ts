import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-exercise-calculator',
  templateUrl: './exercise-calculator.component.html',
  styleUrls: ['./exercise-calculator.component.css']
})
export class ExerciseCalculatorComponent implements OnInit {
  public firstOperand: number = 0;
  public secondOperand: number = 0;
  public operator = '+';
  public result;

  constructor() {
  }

  ngOnInit(): void {
  }

  calculate() {
    switch (this.operator) {
      case "+":
        this.result = this.firstOperand + this.secondOperand;
        break;
      case "-":
        this.result = this.firstOperand - this.secondOperand;
        break;
      case "*":
        this.result = this.firstOperand * this.secondOperand;
        break;
      case "/":
        if (this.secondOperand === 0) {
          this.result = "Can not be divided by zero!";
        } else {
          this.result = this.firstOperand / this.secondOperand;
        }
        break;
    }
  }
}
