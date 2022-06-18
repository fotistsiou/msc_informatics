package unipi.OOP.mathima4;

public class Main {
    public static void main(String[] args) {
        Professor professor = new Professor();
        Student student = new Student();
        Secretary secretary = new Secretary();

        /* Method "professor.acceptPeopleWhoSpeak()" */
        professor.acceptPeopleWhoSpeak(student); // Accepted because the "Student" class implement the "IProfContract" interface.
        professor.acceptPeopleWhoSpeak(secretary); // Accepted because the "Secretary" class implement the "ISpeak" interface.

        /* Method "professor.acceptInCourse()" */
        professor.acceptInCourse(student); // Accepted because the "Student" class implement the "IProfContract" interface.
        // professor.acceptInCourse(se1); // Failed because the "Secretary" class implement the "ISpeak" interface.
    }
}
