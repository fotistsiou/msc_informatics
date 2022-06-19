package unipi.OOP.mathima5.anonymization;

public class Main {
    /* Methods και Class που θα χρησιμοποιηθούν μέσα στην main. */

    // Method doSomethingWithStudent() με argument ένα Student object.
    static void doSomethingWithStudent(Student s) {
        System.out.println(s);
        s.sayHello();
    }

    // Static class SomeClass που κάνει extend την class Student και προσθέτει τη method sayHi_1().
    static class SomeClass extends Student {
        void sayHi_1(){
            System.out.println("Hi 1 from SomeClass");
        }
    }

    // Method doSomethingWithAnyoneThatReads() με argument ένα IRead interface.
    static void doSomethingWithAnyoneThatReads(IRead reader){
        reader.doRead("Java");
    }


    /* Main method και χρήση anonymous classes and methods */

    public static void main(String[] args) {
        // Δημιουργία του object s1 της class Student.
        Student s1 = new Student();
        s1.am = "mppl1111";
        doSomethingWithStudent(s1);

        // Δημιουργία ανώνυμου object, μιας ανώνυμης class, που κάνει έμμεσα extend την class Student και χρησιμοποιεί τον δεύτερο contactor της class Student.
        doSomethingWithStudent(
            new Student("mppl2222", "mppl2222@unipi.gr")
        );

        // Δημιουργία ανώνυμου object, μιας ανώνυμης class, που κάνει έμμεσα extend την class Student, χρησιμοποιεί τον δεύτερο contactor της και χρησιμοποιεί την method sayHello() της class Student.
        // Δεν μπορώ να κάνω χρήση της method doSomethingWithStudent() διότι δέχεται μόνο Student objects.
        new Student("mppl3333", "mppl3333@unipi.gr").sayHello();

        // Δημιουργία ανώνυμου object, μιας ανώνυμης class, που κάνει έμμεσα extend την class SomeClass και χρησιμοποιεί τη method sayHi_1().
        new SomeClass().sayHi_1();

        // Δημιουργία ανώνυμου object, μιας ανώνυμης class, που κάνει έμμεσα extend την class Student, χρησιμοποιεί τον δεύτερο contactor της class Student και προσθέτει τη method sayHi_2().
        // Δεν μπορώ να χρησιμοποιήσω τη method sayHi_3() καθώς η method doSomethingWithStudent() διότι δέχεται μόνο Student objects.
        doSomethingWithStudent(
                new Student("mppl4444", "mppl4444@unipi.gr"){
                    void sayHi_2(){
                        System.out.println("Hi 2 from Student with AM: "+am+" and email: "+email);
                    }
                }
        );

        // Δημιουργία ανώνυμου object, μιας ανώνυμης class, που κάνει έμμεσα extend την class Student, χρησιμοποιεί τον δεύτερο contactor της class Student, προσθέτει τη method sayHi_3() και τη χρησιμοποιεί.
        new Student("mppl5555", "mppl5555@unipi.gr"){
            void sayHi_3(){
                System.out.println("Hi 3 from Student with AM: "+am+" and email: "+email);
            }
        }.sayHi_3();

        // Δημιουργία ανώνυμου object, μιας ανώνυμης class, που κάνει έμμεσα extend την class Student, χρησιμοποιεί τον δεύτερο contactor της class Student, και κάνει override τη method sayHello().
        doSomethingWithStudent(
            new Student("mppl6666", "mppl6666@unipi.gr"){
                @Override
                void sayHello(){
                    System.out.println("Extended Hello from Student with AM: "+am+" and email: "+email);
                }
            }
        );

        // Το αντικείμενο s2 της κλάσεις Student.
        // Μπορούμε το s2 να χρησιμοποιηθεί ως argument στην method doSomethingWithAnyoneThatReads() γιατί η class Student κάνει implement το IREad interface.
        Student s2 = new Student();
        doSomethingWithAnyoneThatReads(s2);

        // Δημιουργία ανώνυμου object, μιας ανώνυμης class, η οποία κάνει implement το IRead interface.
        doSomethingWithAnyoneThatReads(
            new IRead() {
                @Override
                public void doRead(String text) {
                    System.out.println("I am Student 2 that reads "+text);
                }
            }
        );

        // Δημιουργία μεταβλητής που περιέχει ανώνυμο object, μιας ανώνυμης class, η οποία κάνει implement το IRead interface.
        IRead r1 = new IRead() {
            @Override
            public void doRead(String text) {
                System.out.println("I am Student 3 that reads "+text);
            }
        };
        doSomethingWithAnyoneThatReads(r1);
    }
}
