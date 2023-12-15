package com.cahill.pizza.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="menu_item")
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {

    @Id
    private Integer id;
    private String menuCategory;
    private String name;
    private String description;
    private Integer menuItemTypeId;
    private String size;
    private Float price;
    private boolean isSpecialty;

    //private MenuItemPrice[] prices;
    //private Topping[] defaultToppings;
}
