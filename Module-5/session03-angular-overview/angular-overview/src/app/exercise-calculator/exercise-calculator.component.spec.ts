import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExerciseCalculatorComponent } from './exercise-calculator.component';

describe('ExerciseCalculatorComponent', () => {
  let component: ExerciseCalculatorComponent;
  let fixture: ComponentFixture<ExerciseCalculatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExerciseCalculatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExerciseCalculatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
