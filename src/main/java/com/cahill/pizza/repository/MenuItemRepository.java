package com.cahill.pizza.repository;

import com.cahill.pizza.model.MenuItem;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MenuItemRepository extends CrudRepository<MenuItem, Integer> {

    @Query("""
            SELECT
                mi.id, 
                t.name as menuCategory,
                mi.name,
                mi.description,
                mi.is_specialty,
                array_agg(s.name) as sizeNames,
                array_agg(p.price) as prices
            FROM
                menu_item mi
            LEFT JOIN
                menu_item_price p on mi.id = p.menu_item_id
            LEFT JOIN
                menu_item_type t on mi.menu_item_type_id = t.id
            LEFT JOIN
                menu_item_size s on p.menu_item_size_id = s.id
            GROUP BY
                mi.id, t.name, mi.name, mi.description, mi.is_specialty
            """)
    List<MenuItem> findAll();

/*
        SELECT mi.id id, t.name, mi.name, mi.description, mi.is_specialty, s.name, p.price from menu_item mi
    LEFT JOIN menu_item_price p on mi.id = p.menu_item_id
    LEFT JOIN menu_item_type t on mi.menu_item_type_id = t.id
    LEFT JOIN menu_item_size s on p.menu_item_size_id = s.id
    */


}
