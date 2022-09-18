package unipi.OOP.exams_2021;

import java.util.Arrays;

public class B extends Common implements IDoSomething{
    // B's fields
    private int afm;
    private String[] strings;

    // B's Constructors
    public B() {}
    public B(String s1, int i2, Boolean b3, int afm, String[] strings) {
        this.setS1(s1);
        this.setI2(i2);
        this.setB3(b3);
        this.setAfm(afm);
        this.setStrings(strings);
    }

    // Getters & Setters
    public int getAfm() {
        return afm;
    }
    public void setAfm(int afm) {
        this.afm = afm;
    }
    public String[] getStrings() {
        return strings;
    }
    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    // Implement Abstract Interface Method
    @Override
    public String doSomething(int a){
        return "I am the B class and and instance: '"+a+"'";
    }

    // Override toString() method
    public String toString() {
        return "B{'S1': " + getS1() + ", 'I2': " + getI2() + ", 'B3': " + getB3() + ", 'afm': " + getAfm() + ", 'strings': " + Arrays.toString(getStrings())+ "}";
    }
}
