package unipi.OOP.mathima4;

// First Extend and Then Implement
public class Dog extends MyAbstractClass implements IRaiseHand{
    // Implement hello() method from MyAbstractClass.
    @Override
    void hello() {
        System.out.println("Hello. I am a Dog.");
    }

    // Implement raiseHand() method from IRaiseHand.
    @Override
    public void raiseHand() {

    }

    // Implement lowerHand() method from IRaiseHand.
    @Override
    public void lowerHand() {

    }
}
