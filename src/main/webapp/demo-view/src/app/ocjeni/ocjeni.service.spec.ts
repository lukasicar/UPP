import { TestBed, inject } from '@angular/core/testing';

import { OcjeniService } from './ocjeni.service';

describe('OcjeniService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OcjeniService]
    });
  });

  it('should be created', inject([OcjeniService], (service: OcjeniService) => {
    expect(service).toBeTruthy();
  }));
});
