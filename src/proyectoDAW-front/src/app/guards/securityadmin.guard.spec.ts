import { TestBed } from '@angular/core/testing';

import { SecurityadminGuard } from './securityadmin.guard';

describe('SecurityadminGuard', () => {
  let guard: SecurityadminGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(SecurityadminGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
