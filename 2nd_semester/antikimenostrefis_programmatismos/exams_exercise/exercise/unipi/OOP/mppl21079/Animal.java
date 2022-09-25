package unipi.OOP.mppl21079;

import java.util.Objects;
import java.io.*;

public class Animal implements Serializable{
    /* The most general fields of animals. */
    private int animal_code;
    private String animal_name;
    private String animal_category;

    /* Getters and Setters for above fields. */
    public int getAnimal_code() {
        return animal_code;
    }
    public void setAnimal_code(int animal_code) {
        this.animal_code = animal_code;
    }
    public String getAnimal_name() {
        return animal_name;
    }
    public void setAnimal_name(String animal_name) {
        this.animal_name = animal_name;
    }
    public String getAnimal_category() {
        return animal_category;
    }
    public void setAnimal_category(String animal_category) {
        if (Objects.equals(animal_category, "mammal") || Objects.equals(animal_category, "reptilian") || Objects.equals(animal_category, "fish") || Objects.equals(animal_category, "bird") ) {
            this.animal_category = animal_category;
        }
    }
}