import {Component, Input} from '@angular/core';
import {IMenuItem} from "../../../../shared/model/menu-item.interface";

@Component({
  selector: 'app-menu-list-item',
  standalone: true,
  imports: [],
  templateUrl: './menu-list-item.component.html',
  styleUrl: './menu-list-item.component.scss'
})
export class MenuListItemComponent {
  @Input() item: IMenuItem | undefined;
}
