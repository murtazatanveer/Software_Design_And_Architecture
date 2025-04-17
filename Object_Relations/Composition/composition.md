=>Composition:

Composition is a strong "whole-part" relationship where:

. The parent class (whole) owns the child class (part).

. The child cannot exist without the parent (lifecycle dependency).

. The child is typically instantiated inside the parent.

=> Class A use class B , but if class B is detroyed class A also destroyed

Example : The Engine is created when the Car is instantiated.If the Car is destroyed, the Engine is destroyed too.
