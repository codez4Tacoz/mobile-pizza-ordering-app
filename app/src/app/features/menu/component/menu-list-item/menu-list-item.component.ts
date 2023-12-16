import {Component, Input} from '@angular/core';
import {IMenuItem} from "../../../../shared/model/menu-item.interface";
import {Router} from "@angular/router";

@Component({
  selector: 'app-menu-list-item',
  standalone: true,
  imports: [],
  templateUrl: './menu-list-item.component.html',
  styleUrl: './menu-list-item.component.scss'
})
export class MenuListItemComponent {
  @Input() item: IMenuItem | undefined;

  // menu-item.component.ts
  constructor(private router: Router) {}

  addItemToCart(menuItem: any): void {
    //later on there would be a case statement or if-else-ifs ...
    //non-pizza (or more generically, non-configurable items maybe) would get added directly to the cart
    this.router.navigate(['/add-pizza', menuItem.id]);
  }
}
