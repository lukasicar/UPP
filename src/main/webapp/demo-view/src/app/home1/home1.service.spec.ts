import { TestBed, inject } from '@angular/core/testing';

import { Home1Service } from './home1.service';

describe('Home1Service', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [Home1Service]
    });
  });

  it('should be created', inject([Home1Service], (service: Home1Service) => {
    expect(service).toBeTruthy();
  }));
});
