--> Definition of Information Expert

"Assign a responsibility to the class that has the most information , needed 
 for that responsibility to fulfill it."

In simpler terms:

If a class has the necessary data to perform an operation, it should handle that operation.

This minimizes coupling (dependencies between classes) and maximizes cohesion (keeping related logic together).

--> How to Apply Information Expert

Scenario : Shopping Cart System

A ShoppingCart contains multiple Items.

Each Item has a price and quantity.

We need to calculate the total cart price.

Solution :

1. Identify the responsibility (e.g., "calculate total price").

2. Determine which class has the required data (e.g., ShoppingCart knows all Items and their prices).

Assign the responsibility to that class (e.g., ShoppingCart.calculateTotal()).
