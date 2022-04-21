package unipi.OOP.mathima3;

// Main is a static class
public class Main {

    public static void main(String[] args) {
        // Data Types

        // Primitive Data Type
        int i = 10;
        // Reference Data Type
        String name = "Fotis";
        Student s1 = new Student();
        // Wrapper Class
        Integer j = 15;
        j.toString();


        // Non-Access Modifiers

        // Static Methods and Attributes
        Student.classMethod(); // Access static method
        System.out.println(Student.PI); // Access to static final attribute
        System.out.println(SomeClass.str2); // Access to static final attribute
        // System.out.println(SomeClass.str); // Not-Access o static attribute

        // Νon-Abstract & Abstract Classes

        // Νon-Abstract Class
        Student s2 = new Student();
        s2.changedMethod();
        // Abstract Class
        // I can't create an object from SomeOtherSomething class because SomeOtherSomething is an abstract class
        // SomeOtherClass s3 = new SomeOtherClass();
    }
}
