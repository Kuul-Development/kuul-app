import { TestBed } from '@angular/core/testing';

import { SalesmanService } from './salesman.service';

describe('SalesmanService', () => {
  let service: SalesmanService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SalesmanService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
