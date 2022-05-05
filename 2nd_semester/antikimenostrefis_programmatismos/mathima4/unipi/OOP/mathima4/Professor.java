package unipi.OOP.mathima4;

public class Professor {
    // Βάζοντας ως παράμετρο ένα interface, ζητάμε ως παράμετρο ένα ολόκληρο object μιας κλάσης η οποία έχει κάνει implement το ISpeak interface.
    void acceptPeopleWhoSpeak(ISpeak speaker){
        speaker.speak("Informatics Unipi!");
    }

    void acceptInCourse(IProfContract accepted){
        accepted.speak("Informatics Unipi!");
        accepted.raiseHand();
        accepted.lowerHand();
    }
}
