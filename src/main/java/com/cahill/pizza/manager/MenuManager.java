package com.cahill.pizza.manager;

import com.cahill.pizza.model.MenuItem;
import com.cahill.pizza.repository.MenuItemRepository;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.List;

@Named
@RequiredArgsConstructor
public class MenuManager {
    private final MenuItemRepository repository;

    public List<MenuItem> getAllMenuItems() {
        //TODO prepopulate with Flyaway or Liquibase
        repository.save(new MenuItem(1, "Build Your Own Pizza", "Choose your favorite toppings", 10.99f));
        repository.save(new MenuItem(2, "Hawaiian Pizza", "Canadian bacon, pineapple, mozzarella", 12.99f));
        repository.save(new MenuItem(3, "Meat Lovers Pizza", "Pepperoni, sausage, bacon, ham, beef, mozzarella", 14.99f));
        repository.save(new MenuItem(4, "Veggie Supreme Pizza", "Mushrooms, green peppers, onions, black olives, tomatoes, mozzarella", 13.99f));
        repository.save(new MenuItem(5, "Margherita Pizza", "Tomatoes, fresh mozzarella, basil, olive oil", 11.99f));
        repository.save(new MenuItem(6, "Barbecue Chicken Pizza", "Barbecue sauce, grilled chicken, red onions, mozzarella", 13.99f));
        repository.save(new MenuItem(7, "Buffalo Chicken Pizza", "Buffalo sauce, grilled chicken, red onions, blue cheese, mozzarella", 13.99f));
        repository.save(new MenuItem(8, "White Pizza", "Olive oil, garlic, ricotta, mozzarella, spinach", 12.99f));
        repository.save(new MenuItem(9, "Supreme Pizza", "Pepperoni, sausage, mushrooms, green peppers, onions, black olives, mozzarella", 15.99f));
        repository.save(new MenuItem(10, "Four Cheese Pizza", "Mozzarella, cheddar, provolone, parmesan", 12.99f));
        repository.save(new MenuItem(11, "Pepperoni Pizza", "Classic pepperoni, mozzarella", 11.99f));

        return repository.findAll();
    }

}
