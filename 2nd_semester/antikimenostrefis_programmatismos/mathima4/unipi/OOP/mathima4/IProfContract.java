package unipi.OOP.mathima4;

// An interface cannot implement another interface.
// An interface can extend another interface.
// An interface cannot extend a class.
public interface IProfContract extends ISpeak, IRaiseLowerHand {
    // The "IProfContract" interface allows the classes that implement it to implement and the "ISpeak" and "IRaiseLowerHand" interfaces.
}
