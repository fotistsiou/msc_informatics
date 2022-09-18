package unipi.OOP.exams_2021;

public abstract class Common {
    // Common fields
    private String s1;
    private int i2;
    private Boolean b3;

    // Common's Constructors
    public Common() {}
    public Common(String s1, int i2) {
        this.setS1(s1);
        this.setI2(i2);
    }
    public Common(String s1, int i2, boolean b3) {
        this.setS1(s1);
        this.setI2(i2);
        this.setB3(b3);
    }

    // Getters & Setters
    public String getS1() {
        return s1;
    }
    public void setS1(String s1) {
        this.s1 = s1;
    }
    public int getI2() {
        return i2;
    }
    public void setI2(int i2) {
        this.i2 = i2;
    }
    public Boolean getB3() {
        return b3;
    }
    public void setB3(Boolean b3) {
        this.b3 = b3;
    }
}
