package com.cahill.pizza.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="menu_item_size")
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemSize {

    @Id
    private Integer id;
    private String name;
    private String description;
}
