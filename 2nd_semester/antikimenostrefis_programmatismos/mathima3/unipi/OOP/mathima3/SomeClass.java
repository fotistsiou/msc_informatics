package unipi.OOP.mathima3;

public class SomeClass {

    // Final variable with direct initialization
    final int i = 123;

    // Final variable with initialization through contractor
    // Each object/instance makes its own, separate, new "str" final variable, does not change the value of the same "str"
    final String str;
    public SomeClass(String str) {
        this.str = str;
    }

    // Static final variable with direct initialization (obligatory)
    static final String str2 = "Fotis";
}
