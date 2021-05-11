import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExerciseCountdownTimerComponent } from './exercise-countdown-timer.component';

describe('ExerciseCountdownTimerComponent', () => {
  let component: ExerciseCountdownTimerComponent;
  let fixture: ComponentFixture<ExerciseCountdownTimerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExerciseCountdownTimerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExerciseCountdownTimerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
