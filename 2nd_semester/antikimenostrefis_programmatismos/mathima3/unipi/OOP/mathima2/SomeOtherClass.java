package unipi.OOP.mathima2;

// Abstract Class
public abstract class SomeOtherClass {
    int i;
    String name;

    // Non-Abstract method
    void hi(){
        System.out.println("hi");
    }

    // Abstract method
    // If there is an abstract method in a class I must also declare the class as abstract
    abstract void myMethod();
}
