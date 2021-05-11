import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PracticePetComponent } from './practice-pet.component';

describe('PracticePetComponent', () => {
  let component: PracticePetComponent;
  let fixture: ComponentFixture<PracticePetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PracticePetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PracticePetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
