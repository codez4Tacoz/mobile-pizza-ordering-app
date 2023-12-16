import {RouterModule, Routes} from '@angular/router';
import {MenuComponent} from "../features/menu/component/menu/menu.component";
import {AddPizzaComponent} from "../features/menu/component/add-pizza/add-pizza.component";
import {NgModule} from "@angular/core";

export const routes: Routes = [
  { path: '', redirectTo: '/menu', pathMatch: 'full' },
  { path: 'menu', component: MenuComponent },
  { path: 'add-pizza/:id', component: AddPizzaComponent },
];
