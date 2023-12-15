-- We have the concept of pizzas with default toppings (such as base sauce and cheese)...
-- Specialty pizzas have a lot of default toppings.
-- The pizza that is ordered and the pizza's default configuration are two different things.
-- The Frontend (FE) can allow the user to remove toppings if needed (e.g., Meat Lovers minus bacon).


CREATE TABLE IF NOT EXISTS menu_item_type (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) UNIQUE NOT NULL
);

INSERT INTO menu_item_type (name) VALUES ('Pizza');


-- MenuItem table with isSpecialty boolean.
-- -- I don't love having this isSpecialty boolean here...bc it won't apply to other menu item types
-- alternatives would be possibly an "isCustomizable" flag... which would possibly apply to other menu items (sub sandwiches?)
-- OR to create another menuItem type that is "specialty pizza"...
-- i imagine that the frontend will eventually group menu items by the menuItemType
-- Update MenuItem table without price
CREATE TABLE IF NOT EXISTS menu_item (
    id INT PRIMARY KEY,
    menu_item_type_id INT,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    is_specialty BOOLEAN NOT NULL,
    CONSTRAINT fk_menuItemType FOREIGN KEY (menu_item_type_id) REFERENCES menu_item_type(id)
);

-- Insert MenuItems with limited initial offerings
INSERT INTO menu_item (id, menu_item_type_id, name, description, is_specialty) VALUES
    (1, 1, 'Build Your Own', 'Create your own masterpiece!', false),
    (2, 1, 'Pepperoni', 'Pepperoni, tomato sauce, cheese', true),
    (3, 1, 'Vegetarian', 'Assorted veggies, tomato sauce, cheese', true),
    (4, 1, 'Meat Lover', 'Pepperoni, sausage, bacon, tomato sauce, cheese', true);

-- TODO add an auto_increment to id column now that we're done with our initial inserts

-- Create Table MenuItemSize
CREATE TABLE IF NOT EXISTS menu_item_size (
    id INT PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    description TEXT
);

-- Insert MenuItemSize records
-- if we end up selling drinks, these would also have sizes.
INSERT INTO menu_item_size (id, name, description) VALUES
    (1, 'Small', '10-inch'),
    (2, 'Medium', '12-inch'),
    (3, 'Large', '14-inch');

-- if the size_id is not null then we enforce that it must be a FK to the MenuItemSize table
CREATE TABLE IF NOT EXISTS menu_item_price (
    id INT PRIMARY KEY AUTO_INCREMENT,
    menu_item_id INT,
    menu_item_size_id INT,
    price DECIMAL(10, 2) NOT NULL,
    CONSTRAINT fk_menuItemPrices_menuItem FOREIGN KEY (menu_item_id) REFERENCES menu_item (id),
    CONSTRAINT fk_menuItemPrices_menuItemSize FOREIGN KEY (menu_item_size_id) REFERENCES menu_item_size(id),
    CHECK (menu_item_size_id IS NULL OR menu_item_size_id IS NOT NULL)
);

-- Insert MenuItemPrices records
INSERT INTO menu_item_price (menu_item_id, menu_item_size_id, price) VALUES
    (1, 1, 8.99),  -- Small BYO
    (1, 2, 10.99), -- Medium BYO
    (1, 3, 12.99), -- Large BYO
    (2, 1, 11.99), -- Small Pepperoni
    (2, 2, 13.99), -- Medium Pepperoni
    (2, 3, 15.99), -- Large Pepperoni
    (3, 1, 10.99), -- Small Vegetarian
    (3, 2, 12.99), -- Medium Vegetarian
    (3, 3, 14.99), -- Large Vegetarian
    (4, 1, 12.99), -- Small Meat Lover
    (4, 2, 15.99), -- Medium Meat Lover
    (4, 3, 18.99); -- Large Meat Lover

-- Topping categories are mainly for the frontend to group
CREATE TABLE IF NOT EXISTS topping_category (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) UNIQUE NOT NULL
);

-- Populate ToppingCategory with limited categories
INSERT INTO topping_category (name) VALUES
    ('Sauce'),
    ('Cheese'),
    ('Meat'),
    ('Vegetable');

-- Toppings table.
CREATE TABLE IF NOT EXISTS topping (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) UNIQUE NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    topping_category_id INT,
    is_addable BOOLEAN NOT NULL,
    CONSTRAINT fk_topping_toppingCategory FOREIGN KEY (topping_category_id) REFERENCES topping_category(id)
);

-- Populate Topping with limited options
-- in a real-world scenario, I would take the cost of selecting the ids from the category table instead of
-- using "magic numbers" so that the code were more readable and less error-prone
INSERT INTO topping (name, price, topping_category_id, is_addable) VALUES
    ('Sauce', 0.00, 1, true),
    ('Base Pizza Cheese', 0.00, 2, false),
    ('Extra Cheese', 1.50, 2, true),
    ('Pepperoni', 1.00, 3, true),
    ('Mushrooms', 0.75, 4, true),
    ('Onions', 0.50, 4, true),
    ('Green Peppers', 0.50, 4, true),
    ('Sausage', 1.25, 3, true),
    ('Bacon', 1.50, 3, true),
    ('Olives', 0.75, 4, true),
    ('Tomatoes', 0.75, 4, true),
    ('Pineapple', 1.00, 4, true);


-- pizzas come with default toppings, even the BYO
CREATE TABLE IF NOT EXISTS pizza_default_toppings (
    id INT PRIMARY KEY AUTO_INCREMENT,
    menu_item_id INT,
    topping_id INT,
    FOREIGN KEY (menu_item_id) REFERENCES menu_item (id),
    FOREIGN KEY (topping_id) REFERENCES topping(id)
);

-- Populate PizzaDefaultToppings for Specialty Pizzas
-- in a real-world scenario I would take the cost of selecting the ids from the related tables instead of
-- using "magic numbers" so that the code were more readable and less error-prone
INSERT INTO pizza_default_toppings (menu_item_id, topping_id) VALUES
    (1, 1), -- Build Your Own (Sauce)
    (1, 2), -- Build Your Own (Base Pizza Cheese)
    (2, 1), -- Pepperoni (Sauce)
    (2, 2), -- Pepperoni (Base Pizza Cheese)
    (2, 4), -- Pepperoni
    (3, 1), -- Vegetarian (Sauce)
    (3, 2), -- Vegetarian (Base Pizza Cheese)
    (3, 5), -- Vegetarian (Mushrooms)
    (3, 6), -- Vegetarian (Onions)
    (4, 1), -- Meat Lover's (Sauce)
    (4, 2), -- Meat Lover's (Base Pizza Cheese)
    (4, 4), -- Meat Lover's (Pepperoni)
    (4, 8), -- Meat Lover's (Sausage)
    (4, 9); -- Meat Lover's (Bacon)

-- Users need a way of specifying that they only want their toppings on part of the pizza
CREATE TABLE IF NOT EXISTS topping_half_whole_type (
    id INT PRIMARY KEY,
    name VARCHAR(20) UNIQUE NOT NULL
);

-- Populate ToppingHalfWholeType table
INSERT INTO topping_half_whole_type (id, name) VALUES (1, 'Half 1');
INSERT INTO topping_half_whole_type (id, name) VALUES (2, 'Half 2');
INSERT INTO topping_half_whole_type (id, name) VALUES (3, 'Whole');


