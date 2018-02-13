import { TestBed, inject } from '@angular/core/testing';

import { TenderResponseService } from './tender-response.service';

describe('TenderResponseService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TenderResponseService]
    });
  });

  it('should be created', inject([TenderResponseService], (service: TenderResponseService) => {
    expect(service).toBeTruthy();
  }));
});
