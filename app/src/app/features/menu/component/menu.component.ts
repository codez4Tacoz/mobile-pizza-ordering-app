import {Component, inject, OnInit} from '@angular/core';
import { MenuService } from '../service/menu.service';
import {Observable} from "rxjs";
import {AsyncPipe} from "@angular/common";

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [
    AsyncPipe
  ],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.scss'
})
export class MenuComponent implements OnInit{

  private menuService = inject(MenuService);
  menu$: Observable<string> | undefined;

  ngOnInit(): void {
    this.menu$ = this.menuService.getMenu();
  }
}
