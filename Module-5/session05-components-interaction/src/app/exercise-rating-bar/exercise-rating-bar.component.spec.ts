import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExerciseRatingBarComponent } from './exercise-rating-bar.component';

describe('ExerciseRatingBarComponent', () => {
  let component: ExerciseRatingBarComponent;
  let fixture: ComponentFixture<ExerciseRatingBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExerciseRatingBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExerciseRatingBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
