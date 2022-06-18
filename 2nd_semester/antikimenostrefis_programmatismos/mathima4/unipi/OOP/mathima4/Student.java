package unipi.OOP.mathima4;

// Use "implements" keyword in order to inherit from an interface
public class Student implements IProfContract  {
    @Override
    public void raiseHand(String s) {
        System.out.println("I am a Student. "+s);
    }

    @Override
    public void lowerHand(String s) {
        System.out.println("I am a Student. "+s);
    }

    @Override
    public void speak(String s) {
        System.out.println("I am a Student. "+s);
    }
}
