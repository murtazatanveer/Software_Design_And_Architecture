# Controller

What is Controller Concept ?

The Controller acts as an intermediate layer between the user and the business logic . It ensures that the user does not directly interact with the core logic, which improves separation of concerns, maintainability, and scalability.

In this concept we use an intermediate controller layer between user and main logic.

Controller is actually a intermediate class between user and main logic. User interacts with controller class and controller class then interacts with main logic. User doesnot directly access main business logic.

✅ With Controller Concept:

In the withController version, the stackController class acts as an intermediate layer between the user and the stack class. The user interacts with stackController, which then delegates operations to stack. This ensures encapsulation, separation of concerns, and better maintainability, allowing easy modifications without directly changing the stack class.

❌ Without Controller Concept:

In the withoutController version, the user interacts directly with the stack class, calling its methods without any intermediary.
