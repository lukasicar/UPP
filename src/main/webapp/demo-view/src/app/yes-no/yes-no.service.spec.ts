import { TestBed, inject } from '@angular/core/testing';

import { YesNoService } from './yes-no.service';

describe('YesNoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [YesNoService]
    });
  });

  it('should be created', inject([YesNoService], (service: YesNoService) => {
    expect(service).toBeTruthy();
  }));
});
