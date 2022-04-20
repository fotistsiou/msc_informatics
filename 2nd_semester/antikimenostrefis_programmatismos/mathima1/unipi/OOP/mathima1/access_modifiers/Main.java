package unipi.OOP.mathima1.access_modifiers;

import unipi.OOP.mathima1.Student; // Import class from other package

public class Main { // I can create a "Main" class in the different packages, but not in the same package
    public static void main(String[] args) {
        Student student2 = new Student(); // Exists access to "Student" class because it has public access modifier
        // student2.AM = "MPPL56789"; // Does not exists access to "AM" attribute because it has default access modifier
        // If the "AM" attribute had a private access modifier, it would only be accessible within the same class
        // If the "AM" attribute had a private access modifier, it would only be accessible within the same class and the subclasses
    }
}
