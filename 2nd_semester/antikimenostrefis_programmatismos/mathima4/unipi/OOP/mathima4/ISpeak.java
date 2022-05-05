package unipi.OOP.mathima4;

// To interface μοιάζει με abstract class με την διαφορά ότι στο interface μπορώ να βάλω μόνο abstract methods.
// Στο interface δεν μπορώ να βάλω ούτε μη abstract methods ούτε variables.
public interface ISpeak {
    // Όλες οι μεθοδοι των interfaces είναι abstract άρα είναι περοττό να δηλώσουμε την speak ως "abstract".
    void speak(String s);
}
