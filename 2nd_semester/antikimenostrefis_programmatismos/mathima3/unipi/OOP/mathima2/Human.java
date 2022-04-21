package unipi.OOP.mathima2;

// Non-Abstract and Non-Final class with Final Method
public class Human {
    // Method that can be override by subclass
    void changedMethod() {
        System.out.println("I am an overrided method");
    }
    // Method that can not be override by subclass
    static void nonChangedMthod_1() {
        System.out.println("I am not an overrided method");
    }
    // Method that can not be override by subclass
    final void nonChangedMthod_2() {
        System.out.println("I am not an overrided method");
    }
}
