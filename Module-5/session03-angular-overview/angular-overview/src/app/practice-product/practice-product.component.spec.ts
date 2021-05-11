import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PracticeProductComponent } from './practice-product.component';

describe('PracticeProductComponent', () => {
  let component: PracticeProductComponent;
  let fixture: ComponentFixture<PracticeProductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PracticeProductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PracticeProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
