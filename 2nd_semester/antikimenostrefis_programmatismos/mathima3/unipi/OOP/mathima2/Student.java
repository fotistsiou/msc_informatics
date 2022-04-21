package unipi.OOP.mathima2;

// Final class
public final class Student extends Human {
    // Non-access Modifiers

    static String classMessage; // Belong to class not to object
    static final double PI = 3.14; // Belong to class not to object and it is final
    String name;
    String AM;
    // An instance method can use all instance members (instance methods and fields).
    // An instance method can use all static members, because they are common to all objects.
    void saySomething(String s) {
        classMessage = "UNIPI"; // It is valid
        System.out.println("Hello "+s);
    }
    // A static method can use all static members (static methods and fields).
    // A static method CANNOT use any instance members, because for each object they have a different value.
    static  void classMethod() {
        classMessage = "Unipi";
        // name = "John"; // It is NOT valid
        Student s1 = new Student();
        s1.name = "Fotis"; // But this is valid because it refers to a specific object that we initialize above.
        System.out.println("Hello from Student class!");
    }

    // Override of Method

    // I can override the changedMethod() method of Human class because it is an instance method
    @Override // Annotation class
    void changedMethod() {
        System.out.println("Override");
    }
     // // I can not override the nonChange() method of Human class because it is a final method
     // @Override
     // void onChangedMthod_1() {
         // System.out.println("Not Override");
     // }
    // // I can not override the nonChange() method of Human class because it is a final method
    // @Override
    // void onChangedMthod_2() {
    // System.out.println("INot Override");
    // }

}
