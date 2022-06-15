package unipi.OOP.mathima3;

// "Student" is a final class and as a result cannot be extended from another class.
public final class Student extends Human {

    /* Class and Instance Fields */

    static String classMessage = "Hello from Static Field!"; // static field that belong to class not to object
    static final double PI = 3.14; // static final field is the constant in Java
    String name; // instance field that belong to object
    String AM; // instance field that belong to object

    /* Class and Instance Methods */

    // An instance method can use all instance members (instance methods and fields).
    // An instance method can use all static members, because they are common to all objects.
    void saySomething() {
        classMessage = "Non-Static Method"; // It is valid
        System.out.println("Hello from "+classMessage+"!");
    }
    // A static method can use all static members (static methods and fields).
    // A static method CANNOT use any instance members, because for each object they have a different value.
    static void classMethod() {
        classMessage = "Static Method";
        System.out.println("Hello from "+classMessage+"!");
        // name = "John"; // It is NOT valid because "name" is an instance field and different for each object.
        Student s1 = new Student();
        s1.name = "Fotis"; // But this is valid because "name" is a specific field of a specific object.
    }

    /* Override and Access/Non-Access Methods */

    // I can override the changedMethod() method of Human class because it is an instance method
    // I can't override the nonChangedMethod_1() method of Human class because it is a static method
    // I can't override the nonChangedMethod_2() method of Human class because it is a final method
    @Override // Annotation class
    void changedMethod() {
        System.out.println("Override");
    }
}
