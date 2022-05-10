package unipi.OOP.mathima5.anonymization;

public class Main {

    public static void main(String[] args) {
        /* Anonymous Object */

        // Το αντικείμενο s1 της κλάσεις Student
        Student s1 = new Student();
        s1.am = "mppl1231";
        doSomethingWithStudent(s1);
        // Ένα ανώνυμο αντικείμενο της κλάσης Student
        doSomethingWithStudent(new Student("mppl312312", "fotis@test.com"));
        // Χρήση μιας μεθόδους της κλάσης Student από ένα ανώνυμο αντικείμενο της
        new Student("mppl12312", "test@test.com").sayHello();


        /* Anonymous Class */

        // Ανωνυμο αντικειμενο μιας ανωνυμης κλασης
        new Student();
        // Ανωνυμο αντικειμενο μιας ανωνυμης κλασης με έμμεσο extend του Student (static class SomeClass extends Student {})
        new SomeClass().sayHi_1();
        // Ανωνυμο αντικειμενο μιας ανωνυμης κλασης, η οποία κάνει extend την κλάση Student
        new Student("mppl2131", "no-email"){
            void sayHi_2(){
                System.out.println("Hi 2 from "+am);
            }
        }.sayHi_2();
        // Περναμε στην doSomethingWithStudent ενα ανώνυμο αντικειμενο μιας ανωνυμης κλασης που είναι παιδί της κλάσης Student και κανει extend προσθέτοντας μια νεα μέθοδο (ΔΕΝ ΧΡΗΣΙΜΟΠΟΙΕΙΤΑΙ ΠΟΤΕ)
        doSomethingWithStudent(
            new Student("mppl2131", "no-email"){
                void sayHi_3(){
                    System.out.println("Hi 3 from "+am);
                }
            }
        );
        // Περναμε στην doSomethingWithStudent ενα ανώνυμο αντικειμενο μιας ανωνυμης κλασης που είναι παιδί της κλάσης Student και κανει extend κάνοντας override μια μεθοδο της κλάσης Student (ΧΡΗΣΙΜΟΠΟΙΕΙΤΑΙ ΣΠΑΝΙΑ)
        doSomethingWithStudent(
                new Student("mppl2131", "no-email"){
                    @Override
                    void sayHello(){
                        System.out.println("Extended Hello from "+am);
                    }
                }
        );


        /* Anonymous Object and Class with use Interface (ΧΡΗΣΙΜΟΠΟΙΕΙΤΑΙ ΣΥΧΝΑ) */

        // Το αντικείμενο s2 της κλάσεις Student, η οποιά κάνει implement το IRead interface
        Student s2 = new Student();
        doSomethingWithAnyoneThatReads(s2);
        // Ενα ανωνυμο αντικειμενο μιας ανωνυμος κλασης, η οποιά κάνει implement το IRead interface
        doSomethingWithAnyoneThatReads(new IRead() {
            @Override
            public void doRead(String text) {
                System.out.println("I am Fotis that reads "+text);
            }
        });
        // Μια μεταβλητή που περιέχει ένα ανωνυμο αντικειμενο μιας ανωνυμος κλασης, η οποιά κάνει implement το IRead interface
        IRead r1 = new IRead() {
            @Override
            public void doRead(String text) {
                System.out.println("I am Fotis 2 that reads "+text);
            }
        };

    }

    // Used from "Anonymous Class" (new SomeClass();)
    static class SomeClass extends Student {
        void sayHi_1(){
            System.out.println("Hi 1 from SomeClass");
        }
    }

    // Used from "Anonymous Object"
    static void doSomethingWithStudent(Student s) {
        System.out.println(s);
        s.sayHello();
    }

    // Used from "Anonymous Object and Class with use Interface"
    static void doSomethingWithAnyoneThatReads(IRead reader){
        reader.doRead("#C");
    }
}
