=> What is the Creator Principle?

The Creator principle answers the question: "Which class should be responsible for creating instances of another class?. For Example class A creates object for class B then class A only create objects of class B and providing initialization data for Class B without controling class B internal logic" It suggests assigning creation responsibility to a class that:

1. Contains the object (aggregation/composition)

2. Aggregates the object (collections)

3. Closely uses the object

4. Has the initialization data for the object

=> What Creator Principle DOES:

. Class A is responsible for instantiating Class B objects

. Class A determines when/whether to create Class B

. Class A may provide initialization data for Class B

=> What Creator Principle DOES NOT DO:

. Class A does not control Class B's internal logic

. Class A does not manage Class B's entire lifecycle (unless it's also the owner)

. Class A should not modify Class B's state after creation
