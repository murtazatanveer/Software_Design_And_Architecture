=> Defination:

Aggregation is a specialized form of association where one class (the "whole") contains or uses another class (the "part"), but the part can exist independently of the whole. It represents a "has-a" relationship with shared ownership.

=> In aggregation class A uses class B as a attribute but relationship is weak. class B also exists
without class A.

=> Key Characteristics of Aggregation

1. Weak Ownership:

The "part" (e.g., courses) can exist without the "whole" (e.g., student).

2. Bi-Directional or Uni-Directional:

The "whole" knows about the "part," but the "part" may or may not know about the "whole."

3. Lifecycle Independence:

Destroying the "whole" (e.g., student) doesn’t destroy the "part" (e.g., courses).
