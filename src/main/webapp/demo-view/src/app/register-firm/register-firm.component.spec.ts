import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterFirmComponent } from './register-firm.component';

describe('RegisterFirmComponent', () => {
  let component: RegisterFirmComponent;
  let fixture: ComponentFixture<RegisterFirmComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterFirmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterFirmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
