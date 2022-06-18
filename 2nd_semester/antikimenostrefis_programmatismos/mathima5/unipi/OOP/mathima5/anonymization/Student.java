package unipi.OOP.mathima5.anonymization;

public class Student implements IRead{
    // student fields
    String am;
    String email;

    // 1st constructor
    public Student() {}

    // 2nd constructor
    public Student(String am, String email) {
        this.am = am;
        this.email = email;
    }

    // student method
    void sayHello(){
        System.out.println("Hello from "+am);
    }

    // override build-in method
    @Override
    public String toString() {
        return "Student{ am='"+am+"', email='"+email+"'}";
    }

    // override interface method
    @Override
    public void doRead(String text) {
        System.out.println("I am Student 1 that reads "+text);
    }
}
