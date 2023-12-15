package com.cahill.pizza.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table("menu_item_price")
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemPrice {

    @Id
    private Integer id;
    private Integer menuItemId;
    private Integer menuItemSizeId;
    private Float price;
}
