import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {MenuService} from "../../service/menu.service";

@Component({
  selector: 'app-add-pizza',
  standalone: true,
  imports: [],
  templateUrl: './add-pizza.component.html',
  styleUrl: './add-pizza.component.scss'
})
export class AddPizzaComponent implements OnInit {

  pizzaId: number | undefined;
  pizza: any; //TODO Janel add type here

  constructor(private route: ActivatedRoute, private menuService: MenuService) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.pizzaId = Number(params.get('id'));

      this.loadPizza();
    });
  }
  loadPizza() {
    if (this.pizzaId) {
      console.log('getting pizza config for id ', this.pizzaId);
      this.menuService.getPizzaMenuItem(this.pizzaId).subscribe(
        (config: any) => {
          this.pizza = config;
        },
        error => {
          alert('Error loading the page. Please go back and try again');
        }
      );
    }
  }
}
