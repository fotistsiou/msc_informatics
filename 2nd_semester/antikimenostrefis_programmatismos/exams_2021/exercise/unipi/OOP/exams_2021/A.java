package unipi.OOP.exams_2021;

public class A extends Common implements IDoSomething{
    // A's field
    private String myName;

    // A's constructors
    public A(String s1, int i2) {
        super(s1, i2);
    }
    public A(String s1, int i2, Boolean b3, String myName) {
        super(s1, i2, b3);
        this.setMyName(myName);
    }

    // Getter & Setter
    public String getMyName() {
        return myName;
    }
    public void setMyName(String myName) {
        this.myName = myName;
    }

    // Implement Abstract Interface Method
    @Override
    public String doSomething(int a) {
        return "I am the A class and instance: '"+a+"'";
    }

    // Override toString() method
    public String toString() {
        return "A{'S1': " + getS1() + ", 'I2': " + getI2() + ", 'B3': " + getB3() + ", 'myName': " + getMyName() + "}";
    }
}
