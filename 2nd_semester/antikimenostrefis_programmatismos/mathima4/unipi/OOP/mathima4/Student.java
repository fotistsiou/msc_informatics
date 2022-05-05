package unipi.OOP.mathima4;


// Use "implements" keyword in order to inherit from an interface
public class Student implements ISpeak{
    @Override
    public void speak(String s) {
        System.out.println("Hello. I am a Student in "+s);
    }
}
