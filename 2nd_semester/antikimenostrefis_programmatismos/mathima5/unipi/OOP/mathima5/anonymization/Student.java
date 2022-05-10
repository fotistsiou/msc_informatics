package unipi.OOP.mathima5.anonymization;

public class Student implements IRead{
    String am;
    String email;

    public Student() {
    }

    public Student(String am, String email) {
        this.am = am;
        this.email = email;
    }

    void sayHello(){
        System.out.println("Hello from "+am);
    }
    @Override
    public String toString() {
        return "Student{" +
                "am='" + am + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public void doRead(String text) {
        System.out.println("I am a student that reads "+text);
    }
}
