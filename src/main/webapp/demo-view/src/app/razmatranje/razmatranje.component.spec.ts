import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RazmatranjeComponent } from './razmatranje.component';

describe('RazmatranjeComponent', () => {
  let component: RazmatranjeComponent;
  let fixture: ComponentFixture<RazmatranjeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RazmatranjeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RazmatranjeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
