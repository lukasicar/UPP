import { TestBed, inject } from '@angular/core/testing';

import { TenderRequestService } from './tender-request.service';

describe('TenderRequestService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TenderRequestService]
    });
  });

  it('should be created', inject([TenderRequestService], (service: TenderRequestService) => {
    expect(service).toBeTruthy();
  }));
});
