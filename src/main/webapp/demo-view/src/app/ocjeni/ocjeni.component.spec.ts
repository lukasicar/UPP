import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OcjeniComponent } from './ocjeni.component';

describe('OcjeniComponent', () => {
  let component: OcjeniComponent;
  let fixture: ComponentFixture<OcjeniComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OcjeniComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OcjeniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
