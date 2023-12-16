import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IPizza} from "../../../shared/model/pizza.interface";

@Injectable({
  providedIn: 'root'
})
export class PizzaService {
  //later on we will want to pull the baseUrl from a config file as it likely
  // will vary based on what environment we're running in
  private baseUrl = '/api';
  constructor(private http: HttpClient) {}

  getPizza(id: number): Observable<IPizza> {
    const url = `${this.baseUrl}/menu/pizza/${id}`;
    return this.http.get<IPizza>(url);
  }
}
