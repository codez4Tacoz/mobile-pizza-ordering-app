package com.cahill.pizza.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="menu_item_price")
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemPrice {

    @Id
    private Integer id;
    private Integer menuItemId;
    private Integer menuItemSizeId;
    private Float price;
}
