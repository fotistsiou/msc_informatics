package unipi.OOP.mathima3;

// "Human" is a Non-Abstract and Non-Final class with Non-Static, Static and Final Methods
public class Human {
    // Non-Static Method. Method can be overridden by subclass.
    void changedMethod() {
        System.out.println("I am an overridden method.");
    }

    // Static Method. Method cannot be overridden by subclass.
    static void nonChangedMethod_1() {
        System.out.println("II am not an overridden method.");
    }

    // Final Method. Method cannot be overridden by subclass.
    final void nonChangedMethod_2() {
        System.out.println("I am not an overridden method.");
    }
}
