package com.cahill.pizza.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("menu_item")
@NoArgsConstructor
@AllArgsConstructor
public class Pizza implements MenuItem {

    @Id
    private Integer id;
    private String menuCategory;
    private String name;
    private String description;
    private boolean isSpecialty;

    private String priceDisplayStr;


/*    private List<String> sizeNames;
    private List<String> prices;*/

/*    private Integer menuItemTypeId;
    private String size;*/
    //private MenuItemPrice[] prices;
    //private Topping[] defaultToppings;
}
