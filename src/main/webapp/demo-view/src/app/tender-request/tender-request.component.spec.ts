import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TenderRequestComponent } from './tender-request.component';

describe('TenderRequestComponent', () => {
  let component: TenderRequestComponent;
  let fixture: ComponentFixture<TenderRequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TenderRequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TenderRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
