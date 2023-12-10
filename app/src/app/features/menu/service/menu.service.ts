import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MenuService {
  menuUrl : string = `api/menu`;

  constructor(private http: HttpClient) { }

  getMenu() :Observable<any>    {
    return this.http.get(this.menuUrl );
  }
}
