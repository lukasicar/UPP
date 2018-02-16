import { TestBed, inject } from '@angular/core/testing';

import { RazmatranjeService } from './razmatranje.service';

describe('RazmatranjeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RazmatranjeService]
    });
  });

  it('should be created', inject([RazmatranjeService], (service: RazmatranjeService) => {
    expect(service).toBeTruthy();
  }));
});
