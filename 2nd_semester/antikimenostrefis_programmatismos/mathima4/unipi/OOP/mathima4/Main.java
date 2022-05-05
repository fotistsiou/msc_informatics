package unipi.OOP.mathima4;

public class Main {

    public static void main(String[] args) {
        Professor p1 = new Professor();
        Student s1 = new Student();
        Secretary se1 = new Secretary();
        Dog d1 = new Dog();

        // p1.acceptPeopleWhoSpeak() method
        d1.hello(); // Accepted διότι το Dog class έχει κάνει implement το MyAbstractClass class.
        // p1.acceptPeopleWhoSpeak(d1); // Failed διότι το Dog class δεν έχει κάνει implement το ISpeak interface.
        p1.acceptPeopleWhoSpeak(s1); // Accepted διοτι το Student class κανει implement το ISpeak interface.
        p1.acceptPeopleWhoSpeak(se1); // Accepted διοτι το Secretary class κανει implement το IProfContract interface που κάνει extend το ISpeak interface.

        // p1.acceptInCourse() method
        // p1.acceptInCourse(d1); // Failed διότι το Dog class δεν έχει κάνει implement το IProfContract interface.
        // p1.acceptInCourse(s1); // Failed διότι το Student class δεν έχει κάνει implement το IProfContract interface.
        p1.acceptInCourse(se1); // Accepted διοτι το Secretary class κανει implement το IProfContract interface.
    }

}
