NOME: 
STUDENT_NUMBER:

CODE DESCRIPTION:

This project is a robot simulator. The robots are Triangules, and they have some shared methods that is encapsulated on the `Triangule.java` class.

Every robot class should inherits from the Triangule class. This class has the general methods that should be available and could be used by the robot's class, such `display()`, `hasReachedMaxWidth()`, and so fourth. It is an abstract class, it means it has some abstract methods that should be implemented when inherit from it. Those methods are signatures only, it means every concrete class should implement them according to its behavior.

In this attchment, we also have the `RandomWalk.java` class, that implements the `Triangule` class. The `RandomWalk` class is a robot factory that makes the robot to move randomly on the background area. Its movements are controlled by the `generateRandom()` method, that tells out of all the movements, which one should behave like in the iteration. The available moves are: `do nothing`; `turn right`, `turn left`, `walk vertically`, `walk horizontally`, `walk forwards` or `walk backwards`.

We also have in it the `Patroller.java` class, that is a robot implementation of a patroller. Its movements behaves in the way the robot should look for the border and run around the background window, and drop a `circle on every corner`.

Finally, we have a `runner.java` class that instantiates the classes and makes it run by calling its interface methods.

HOW TO COMPILE/RUN:

Open the `Processing` program, create a window for each class here described, and then run the `runner.java` class. You will have the project running, and you can edit the params on the objects instantiating.
