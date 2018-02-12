import { TestBed, inject } from '@angular/core/testing';

import { RegisterFirmService } from './register-firm.service';

describe('RegisterFirmService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RegisterFirmService]
    });
  });

  it('should be created', inject([RegisterFirmService], (service: RegisterFirmService) => {
    expect(service).toBeTruthy();
  }));
});
