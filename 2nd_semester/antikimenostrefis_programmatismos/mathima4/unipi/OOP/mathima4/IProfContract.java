package unipi.OOP.mathima4;

// Ένα interface δεν μπορει να κανει implement κάποιο interface.
// Ένα interface μπορει να κάνει extend όσα interface θέλει.
// Ένα interface δεν μπορεί να κάνει extend μια κλάση.
public interface IProfContract extends ISpeak, IRaiseHand{
    // Κανει extend τα interfaces ISpeak και IRaiseHand με αποτέλεσμα όποια μέθοδος πάρει σαν argument το interface IProfContract (Professor -> acceptInCourse) να απαιτεί απο το object που θα την καλέσει (στην Main), να έχει κάνει implement το IProfContract και κατα συνέπεια να έχει αρχικοποιήσει τις μεθόδους του ISpeak interface και του IRaiseHand interface (speak, raiseHand, lowerHand).

}
