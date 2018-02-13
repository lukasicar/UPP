import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TenderResponseComponent } from './tender-response.component';

describe('TenderResponseComponent', () => {
  let component: TenderResponseComponent;
  let fixture: ComponentFixture<TenderResponseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TenderResponseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TenderResponseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
