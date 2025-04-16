=> What is Polymorphism in GRASP?

Definition: Assign responsibilities to classes using polymorphic operations (methods) to allow interchangeable behaviors without conditional logic.

=> Polymorphism’s Role

> Polymorphism extends expert by letting subclasses handle specialized behavior.
> Polymorphic factories (e.g., PaymentMethodFactory) can create instances.
> Polymorphism is a way to protect against variations (hide implementations behind interfaces).


=> Tip : "One interface, many implementations."
Different classes can implement the same method in different ways, while code that uses the interface doesn’t need to know the details.