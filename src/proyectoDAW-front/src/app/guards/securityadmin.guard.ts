import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SecurityadminGuard implements CanActivate {
  isLogin: string;
  isAdmin: string;

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
      this.isLogin = sessionStorage.getItem('isLogin');
      this.isAdmin = sessionStorage.getItem('isAdmin');
      if(this.isLogin == 'true' && this.isAdmin == 'true') {
        return true;
      } else {
        return false;
      }
  }
  
}
