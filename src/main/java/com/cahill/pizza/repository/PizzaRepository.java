package com.cahill.pizza.repository;

import com.cahill.pizza.model.Pizza;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PizzaRepository extends CrudRepository<Pizza, Integer> {

    @Query("""
            SELECT
                pizza.id,
                t.name as menuCategory,
                pizza.name,
                pizza.description,
                pizza.is_specialty,
                CONCAT(MIN(p.price), ' - ', MAX(p.price)) as price_display_str
            FROM
                pizza
            LEFT JOIN
                menu_item_price p on pizza.id = p.menu_item_id
            LEFT JOIN
                menu_item_type t on pizza.menu_item_type_id = t.id
            LEFT JOIN
                menu_item_size s on p.menu_item_size_id = s.id
            GROUP BY
                pizza.id, t.name, pizza.name, pizza.description, pizza.is_specialty
            """)
    List<Pizza> findAll();

    @Query("""
            SELECT
                pizza.id,
                t.name as menuCategory,
                pizza.name,
                pizza.description,
                pizza.is_specialty,
                CONCAT(MIN(p.price), ' - ', MAX(p.price)) as price_display_str,
                array_agg(s.name) as size_names,
                array_agg(p.price) as prices
            FROM
                pizza pizza
            LEFT JOIN
                menu_item_price p on pizza.id = p.menu_item_id
            LEFT JOIN
                menu_item_type t on pizza.menu_item_type_id = t.id
            LEFT JOIN
                menu_item_size s on p.menu_item_size_id = s.id
            WHERE
                pizza.id = :id
            """)
    Pizza getById(@Param("id") Integer id);
}
