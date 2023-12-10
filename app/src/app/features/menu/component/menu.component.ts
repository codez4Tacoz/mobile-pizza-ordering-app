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
  menu$: Observable<string> | undefined;

  private menuService = inject(MenuService);

  ngOnInit(): void {
    this.menu$ = this.menuService.getMenu();
  }
}
