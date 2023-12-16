import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IMenuItem} from "../../../shared/model/menu-item.interface";

@Injectable({
  providedIn: 'root'
})
export class MenuService {
  //later on we will want to pull the baseUrl from a config file as it likely
  // will vary based on what environment we're running in
  baseUrl : string = `api/menu`;

  constructor(private http: HttpClient) { }

  getMenu() :Observable<IMenuItem[]>    {
    return this.http.get<IMenuItem[]>(this.baseUrl );
  }

  getPizzaMenuItem(id: number): Observable<any> {
    const url = `${this.baseUrl}/pizza/${id}`;
    return this.http.get(url);
  }
}
