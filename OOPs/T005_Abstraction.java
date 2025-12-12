/*
Abstraction in Java
Abstraction is a process of hiding the implementation details and showing only functionality to the user.
Ways to achieve Abstraction
There are teo ways to achieve abstraction in java
Abstract class(0 to 100%)
Interface (100%)
Points to Remember
An abstract class must be declared with an abstract keyword.
It can have abstract and non-abstract methods(Concrete)
It cannot be instantiated.
It can have constructors and static methods.
It can have constructors and static methods also.
dgIt can have final methods which will force the subclass not to change the body of the method.
Abstract class having constructor, data member and methods
An abstract class can have a data member, abstract method, method body(non-abstract method), constructor, and even main() method.
If you are extending an abstract class that class must be abstract.
If you are extending an abstract class that has an abstract method,
you must either provide the implementation of the method or make this class abstract.
 */

//Example of an abstract class that has abstract and non-abstract methods.
abstract class Bike{
    Bike(){
        System.out.println("Bike is Created");
    }
    abstract void run();
    void ChangeGare(){
        System.out.println("Gare Changed");
    }
}

// Creating a child class which inherits abstract class
class Honda extends Bike {
    void run(){// this is not overriding, it is nothing
        // but just the implementation code
        System.out.println("Running Safely..");
    }
}

// Creating a Test Class which calls abstract and non-abstract methods
public class T005_Abstraction {
    public static void main(String[] args) {
        Bike obj=new Honda();// first parent constructor get call
        obj.run();
        obj.ChangeGare();
    }
}
