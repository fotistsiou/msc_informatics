package unipi.OOP.mathima1;

// Main class is executable because it has main() method
public class Main {
    public static void main(String[] args) {
        Professor professor1; // Declaration object. professor1 -> null
        professor1 = new Professor(); // Instantiation object. professor1 -> pointer (not null)
        professor1.name = "Alepis"; // Define the professor1's name
        professor1.email = "alepis@unipi.gr"; // Define the professor1's email
        professor1.officeNumber = 56; // Define the professor1's officeNumber
        professor1.changeEmail("talepis@unipi.gr"); // Use the changeEmail() method from Human class
        professor1.teach("Object Oriented Programming with Java"); // Use the teach() method from Professor class

        Student student1; // Declaration object. student1 -> null
        student1 = new Student(); // Instantiation object. student1 -> pointer (not null)
        student1.name = "Fotis"; // Define the student1's name
        student1.email = "tsioumas@outlook.com"; // // Define the student1's email
        student1.AM = "MPPL01234"; // Define the student1's AM
        student1.changeEmail("fotis.tsioumas@outlook.com"); // Use the changeEmail() method from Human class
        student1.grade("Object Oriented Programming with Java", 10); // Use the grade() method from Student class
    }
}