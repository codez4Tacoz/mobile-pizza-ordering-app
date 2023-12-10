import {Component, inject, OnInit} from '@angular/core';
import { MenuService } from '../../service/menu.service';
import {Observable} from "rxjs";
import {AsyncPipe, CommonModule} from "@angular/common";
import {IMenuItem} from "../../../../shared/model/menu-item.interface";
import {MenuListItemComponent} from "../menu-list-item/menu-list-item.component";

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [
    AsyncPipe,
    MenuListItemComponent,
    CommonModule
  ],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.scss'
})
export class MenuComponent implements OnInit{
  menu$: Observable<IMenuItem[]> | undefined;

  private menuService = inject(MenuService);

  ngOnInit(): void {
    this.menu$ = this.menuService.getMenu();
  }


}

