import { TestBed } from '@angular/core/testing';

import { ShortenurlService } from './shortenurl.service';

describe('ShortenurlService', () => {
  let service: ShortenurlService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShortenurlService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
