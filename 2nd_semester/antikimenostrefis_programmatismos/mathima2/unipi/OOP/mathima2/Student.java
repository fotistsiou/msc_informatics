package unipi.OOP.mathima2;

public class Student {
    // I create each attribute with private access modifier
    private String name;
    private String AM;
    private int age;

    // -------------------- Constructors ------------------- //

    // Default Constructor
    public Student() {
        // If I remove the default constructor, then I will not be able to create a student without AM.
    }

    // Constructor for AM attribute
    public Student(String AM) {
        this.AM = AM; // this = reference to current object
    }

    // Constructor for name and AM attributes
    public Student(String name, String AM) {
        this.name = name;
        this.AM = AM;
    }

    // // Extend Constructor
    // public Student(String AM) {
    //      this("No-name", AM);
    //      // or
    //      this.name = "Fotis";
    //      this.AM = AM;
    // }

    // Constructors && Setters
    // In the following way, by placing the condition setter inside the constructor, I ensure that my object will open with the allowed AM and age
    public Student(String AM, int age) {
        this.setAM(AM);
        this.setAge(age);
    }

    // -------------------- Getters & Setters ------------------- //
    // I use getters and setter in order to have access to the private attributes from the other classes

    // Getter for Name -> read only
    public String getName() {
        return name;
    }

    // Getter for AM -> read only
    public String getAM() {
        return AM;
    }

    // Setter for AM -> restriction AM starts with MPPL
    public void setAM(String AM) {
        if (AM.startsWith("MPPL")) {
            this.AM = AM;
        } else {
            this.AM = "Wrong AM";
        }
    }

    // Getter for Age -> read only
    public int getAge() {
        return age;
    }

    // Setter for Age -> restrictions
    public void setAge(int age) {
        if (age > 0 && age < 125) {
            this.age = age;
        }
    }
}