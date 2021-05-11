import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExerciseLoginComponent } from './exercise-login.component';

describe('ExerciseLoginComponent', () => {
  let component: ExerciseLoginComponent;
  let fixture: ComponentFixture<ExerciseLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExerciseLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExerciseLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
