-- Insert data into Pizza table
INSERT INTO Pizza (pizza_id, name, base_price)
VALUES
    (1, 'Margherita', 9.99),
    (2, 'Pepperoni', 10.99),
    (3, 'Vegetarian', 11.99);

-- Insert data into Topping table
INSERT INTO Topping (topping_id, name, price)
VALUES
    (1, 'Mushrooms', 1.50),
    (2, 'Olives', 1.25),
    (3, 'Peppers', 1.75),
    (4, 'Onions', 1.00);

-- Insert data into Size table
INSERT INTO Size (size_id, name, price)
VALUES
    (1, 'Small', 8.99),
    (2, 'Medium', 10.99),
    (3, 'Large', 12.99);