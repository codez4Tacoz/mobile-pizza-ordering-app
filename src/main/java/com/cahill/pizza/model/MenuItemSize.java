package com.cahill.pizza.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table("menu_item_size")
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemSize {

    @Id
    private Integer id;
    private String name;
    private String description;
}
