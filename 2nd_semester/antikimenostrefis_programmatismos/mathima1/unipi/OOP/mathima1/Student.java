package unipi.OOP.mathima1;

// Student class isn't executable because it hasn't main() method
public class Student extends Human{
    // String name; -> inherited from Human
    // String email; -> inherited from Human
    String AM; // Student attribute/field

    // void changeEmail(); -> inherited from Human
    void grade(String course, int grade){
        System.out.println("My name is "+name+" and in course "+course+" I took: "+grade+".");
    } // Student method
}