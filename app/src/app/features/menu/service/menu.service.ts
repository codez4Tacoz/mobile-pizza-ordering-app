import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IMenuItem} from "../../../shared/model/menu-item.interface";

@Injectable({
  providedIn: 'root'
})
export class MenuService {
  menuUrl : string = `api/menu`;

  constructor(private http: HttpClient) { }

  getMenu() :Observable<IMenuItem[]>    {
    return this.http.get<IMenuItem[]>(this.menuUrl );
  }
}
