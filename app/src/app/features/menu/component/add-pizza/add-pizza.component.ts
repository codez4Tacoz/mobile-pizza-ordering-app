import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {MenuService} from "../../service/menu.service";
import {MatChipsModule} from "@angular/material/chips";
import {IPizza} from "../../../../shared/model/pizza.interface";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-add-pizza',
  standalone: true,
  imports: [
    MatChipsModule,
    NgIf,
    NgForOf
  ],
  templateUrl: './add-pizza.component.html',
  styleUrl: './add-pizza.component.scss'
})
export class AddPizzaComponent implements OnInit {

  pizzaId: number | undefined;
  pizza: IPizza | undefined;

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
        (config: IPizza) => {
          this.pizza = config;

          console.log('this is the pizza config from the server: ', this.pizza);
        },
        error => {
          alert('Error loading the page. Please go back and try again');
        }
      );
    }
  }
}
