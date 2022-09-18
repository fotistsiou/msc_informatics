package unipi.OOP.exams_2021;

public class D extends Common{
    public D (String s1, int i2, boolean b3) {
        super(s1,i2,b3);
    }

    public String toString() {
        return "D{'S1': " + getS1() + ", 'I2': " + getI2() + ", 'B3': " + getB3() + "} -> Does not implement IDoSomething and therefore cannot be added to list c.";
    }
}
