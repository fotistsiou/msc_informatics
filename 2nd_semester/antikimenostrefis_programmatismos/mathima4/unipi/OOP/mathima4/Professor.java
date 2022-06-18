package unipi.OOP.mathima4;

public class Professor {
    // Put the "ISpeak" interface in the "acceptPeopleWhoSpeak" method as argument an add an alias for this interface so that all object that that can use this method to have a class that implement "ISpeak" interface.
    void acceptPeopleWhoSpeak(ISpeak speaker){
        speaker.speak("I can speak!");
    }

    // Put the "IProfContract" interface in the "acceptInCourse" method as argument an add an alias for this interface so that all object that that can use this method to have a class that implement "ISpeak" and "IRaiseLowerHand" interface.
    void acceptInCourse(IProfContract accepted){
        accepted.speak("I can speak!");
        accepted.raiseHand("I can raise my hand!");
        accepted.lowerHand("I can lower my hand!");
    }
}
