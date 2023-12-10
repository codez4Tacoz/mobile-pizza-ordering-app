package com.cahill.pizza.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="orders")
public class Order {
    @Id
    private Integer id;
    //private MenuItem orderItems;
    private float subTotalAmount;
    private float taxAmount;
    private float totalAmount;
}
