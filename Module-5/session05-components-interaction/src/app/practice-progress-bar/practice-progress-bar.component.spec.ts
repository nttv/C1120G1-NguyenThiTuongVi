import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PracticeProgressBarComponent } from './practice-progress-bar.component';

describe('PracticeProgressBarComponent', () => {
  let component: PracticeProgressBarComponent;
  let fixture: ComponentFixture<PracticeProgressBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PracticeProgressBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PracticeProgressBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
