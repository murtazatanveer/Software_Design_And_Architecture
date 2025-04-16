=> Low Coupling is a design principle that aims to minimize dependencies between classes/modules.

=>The main purpose of low coupling is to reduce dependencies between classes.

=> Core Idea of Low Coupling

"Minimize how much one class needs to know about another."

=> Some main Approaches to achieve it

1. Program to Interfaces (Not Implementations)
   Why: Depend on abstractions so implementations can change without affecting callers.

2. Law of Demeter ("Don’t Talk to Strangers")
   Why: Reduce knowledge of other classes' internals.

3. Dependency Injection (DI)
   Why: Let external code provide dependencies instead of creating them internally.
