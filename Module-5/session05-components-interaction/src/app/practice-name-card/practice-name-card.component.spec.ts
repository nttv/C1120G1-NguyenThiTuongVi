import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PracticeNameCardComponent } from './practice-name-card.component';

describe('PracticeNameCardComponent', () => {
  let component: PracticeNameCardComponent;
  let fixture: ComponentFixture<PracticeNameCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PracticeNameCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PracticeNameCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
