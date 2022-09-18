package unipi.OOP.mathima5.serialization;

import java.io.Serializable;

// The "Professor" class have to implement the "Serializable" interface.
public class Professor implements Serializable {
    private int officeNumber;
    private String name;

    public Professor(int officeNumber, String name) {
        setOfficeNumber(officeNumber);
        setName(name);
    }

    public int getOfficeNumber() {
        return officeNumber;
    }
    public void setOfficeNumber(int officeNumber) {
        this.officeNumber = officeNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Professor Name: "+this.getName()+", Professor Office Number: "+this.getOfficeNumber();
    }
}
