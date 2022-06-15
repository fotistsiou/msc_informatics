package unipi.OOP.mathima3;

// In order to be able to extend SomeOtherClass class, I have to immediately override the myMethod() method.
public class ExtendingAbstract extends SomeOtherClass {
    @Override
    void myMethod() {
        System.out.println("I am 'myMethod' from ExtendingAbstract class!");
    }
}
