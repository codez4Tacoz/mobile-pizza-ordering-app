package com.cahill.pizza.model;

public interface MenuItem {
    Integer getId();
    String getMenuCategory();
    String getName();
    String getDescription();
    String getPriceDisplayStr();
}
