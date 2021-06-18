import { TestBed } from '@angular/core/testing';

import { SecurityuserGuard } from './securityuser.guard';

describe('SecurityuserGuard', () => {
  let guard: SecurityuserGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(SecurityuserGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
