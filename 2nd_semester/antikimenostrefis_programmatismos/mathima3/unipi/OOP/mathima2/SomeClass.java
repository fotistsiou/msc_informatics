package unipi.OOP.mathima2;

// I can not extend the Student class because Student is a final class
public class SomeClass /* extends Student */ {

    // Final variable with direct initialization
    final int i = 123;

    // Final variable with initialization through contractor
    // Each object/instance makes its own, separate, new "str" final variable, does not change the value of the same "str"
    final String str;
    public SomeClass(String str) {
        this.str = str;
    }

    // Static final variable
    static final String str2 = "Fotis";
}
