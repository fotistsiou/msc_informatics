package unipi.OOP.mathima3;

// Main is a static class
public class Main {

    public static void main(String[] args) {
        /* Data Types */

        // Primitive Data Type
        int i = 10;

        // Reference Data Type
        String name = "Fotis";
        Student s1 = new Student();

        // Wrapper Class
        Integer j = 15;
        j.toString();


        /* Non-Access Modifiers */

        // Static Methods and Fields
        System.out.println(Student.classMessage); // Access to the static field "classMessage" from the class
        Student s2 = new Student();
        s2.saySomething(); // Access to the static filed "classMessage" from a non-static method
        Student.classMethod(); // Access to the static filed "classMessage" from a static method

        // Static Final Fields
        System.out.println(Student.PI); // Access to static final field
        System.out.println(SomeClass.str2); // Access to static final field

        // Final Fields
        // System.out.println(SomeClass.str); // Non-Access to final field "str" within the class
        SomeClass str_access = new SomeClass("I have access to 'str' only within constructor!");
        System.out.println(str_access.str);


        /* Νon-Abstract & Abstract Classes */

        // I can't create an object from the "SomeOtherSomething" class because is an abstract class
        // However, I can create an object from the "ExtendingAbstract" class because EXTEND the "SomeOtherSomething" and OVERRIDE her method "myMethod()"
        ExtendingAbstract s3 = new ExtendingAbstract();
        s3.myMethod();

    }
}
