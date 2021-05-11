import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PracticeFontSizeEditorComponent } from './practice-font-size-editor.component';

describe('PracticeFontSizeEditorComponent', () => {
  let component: PracticeFontSizeEditorComponent;
  let fixture: ComponentFixture<PracticeFontSizeEditorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PracticeFontSizeEditorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PracticeFontSizeEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
