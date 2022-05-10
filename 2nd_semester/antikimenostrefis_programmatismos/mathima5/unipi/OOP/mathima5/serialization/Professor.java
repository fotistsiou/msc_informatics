package unipi.OOP.mathima5.serialization;

import java.io.Serializable;

public class Professor implements Serializable {
    private int officeNumber;
    private String name;

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
}
