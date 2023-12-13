-- Create Pizza Table
CREATE TABLE pizza (
                       pizza_id INT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       base_price DECIMAL(10, 2) NOT NULL
);

-- Create Topping Table
CREATE TABLE Topping (
                         topping_id INT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         price DECIMAL(6, 2) NOT NULL
);

-- Create Size Table
CREATE TABLE Size (
                      size_id INT PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      price DECIMAL(6, 2) NOT NULL
);
/*

-- Create Order Table
CREATE TABLE Order (
                       order_id INT PRIMARY KEY,
                       pizza_id INT,
                       size_id INT,
                       total_price DECIMAL(10, 2) NOT NULL,
                       FOREIGN KEY (pizza_id) REFERENCES Pizza(pizza_id),
                       FOREIGN KEY (size_id) REFERENCES Size(size_id)
);

-- Create OrderToppings Table (to handle the many-to-many relationship between orders and toppings)
CREATE TABLE OrderToppings (
                               order_id INT,
                               topping_id INT,
                               PRIMARY KEY (order_id, topping_id),
                               FOREIGN KEY (order_id) REFERENCES Order(order_id),
                               FOREIGN KEY (topping_id) REFERENCES Topping(topping_id)
);
*/
