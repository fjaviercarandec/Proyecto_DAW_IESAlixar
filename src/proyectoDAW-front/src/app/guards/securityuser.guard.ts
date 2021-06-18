import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class SecurityuserGuard implements CanActivate {
  isLogin: string;

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    this.isLogin = sessionStorage.getItem('isLogin');
    if(this.isLogin == 'true') {
      return true;
    } else {
      return false;
    }
  }
  
}
