package unipi.OOP.mathima2;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
         // Constructors
         Student s1 = new Student(); // Constructor: Student();
         // System.out.println(s1.AM); -> I haven't access because AM has private access modifier
         Student s2 = new Student("MPPL21123"); // Constructor: new Student(String AM);
         // System.out.println(s2.AM); -> I haven't access because AM has private access modifier
         // s2.AM = "ΜΠΠΛ21124"; -> I haven't access because AM has private access modifier

         // Getters & Setters
         Student s3 = new Student("ΜΠΠΛ21123");
         System.out.println(s3.getAM());
         s3.setAge(2756);
         System.out.println(s3.getAge()); // return 0
         s3.setAge(27);
         System.out.println(s3.getAge()); // return 27

         // Scanner
         Scanner scanner1 = new Scanner(System.in); // System.in -> input from console
         System.out.println("Please write something");
         String s4 = scanner1.nextLine(); // Read until find new line
         System.out.println("You entered: "+s4);
         System.out.println("Please write something");
         String s5 = scanner1.next(); // Read until find space
         System.out.println("You entered: "+s5);
         System.out.println("Please give a number:");
         int i = scanner1.nextInt();
         System.out.println("Number is: "+i);

         // Casting
         Scanner scanner2 = new Scanner(System.in);
         System.out.println("Please give a number:");
         String s6 = scanner2.next();
         System.out.println("Please give another number:");
         String s7 = scanner2.next();
         String sum = s6+s7;
         System.out.println("Sum is:"+sum); // -> concatenate strings
         System.out.println("Please give a number:");
         String s8 = scanner2.next();
         System.out.println("Please give another number:");
         String s9 = scanner2.next();
         int firstNumber = Integer.parseInt(s8); // -> string to int
         int secondNumber = Integer.parseInt(s9); // -> string to int
         int sum2 = firstNumber+secondNumber;
         System.out.println("Sum is:"+sum2); // -> sum of string

         // Build-in functions for strings
         String s10 = "Hello World";
         String newString = s10.toUpperCase();
         System.out.println(newString);
         if (s10.endsWith("World"))
             System.out.println("What you entered ends with world");

    }
}
