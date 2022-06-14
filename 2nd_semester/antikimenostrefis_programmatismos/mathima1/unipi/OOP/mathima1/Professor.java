package unipi.OOP.mathima1;

// Professor class isn't executable because it hasn't main() method
public class Professor extends Human {
    // String name; -> inherited from Human
    // String email; -> inherited from Human
    int officeNumber; // Professor attribute/field

    // void changeEmail(); -> inherited from Human
    void teach(String course){
        System.out.println("My name is "+name+" with email "+email+" and I am teaching "+course+".");
    } // Professor method
}
