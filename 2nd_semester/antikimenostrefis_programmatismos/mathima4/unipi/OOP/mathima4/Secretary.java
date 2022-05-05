package unipi.OOP.mathima4;

public class Secretary implements  IProfContract{

    @Override
    public void raiseHand() {
    }

    @Override
    public void lowerHand() {
    }

    @Override
    public void speak(String s) {
        System.out.println("Hello. I am a Secretary in "+s+" Also I can raise and lower my hand!");
    }
}
