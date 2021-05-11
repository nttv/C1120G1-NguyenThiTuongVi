import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExerciseColorPickerComponent } from './exercise-color-picker.component';

describe('ExerciseColorPickerComponent', () => {
  let component: ExerciseColorPickerComponent;
  let fixture: ComponentFixture<ExerciseColorPickerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExerciseColorPickerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExerciseColorPickerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
