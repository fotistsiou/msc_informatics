package unipi.OOP.mathima4;

public class Secretary implements ISpeak {
    @Override
    public void speak(String s) {
        System.out.println("I am a Secretary. "+s);
    }
}
