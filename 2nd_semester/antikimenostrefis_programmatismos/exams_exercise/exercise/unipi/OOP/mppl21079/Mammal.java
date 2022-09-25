package unipi.OOP.mppl21079;

import java.io.Serializable;

public class Mammal extends Animal implements Feed, Serializable{
    /* Some specific fields of Mammal. */
    private double weight;
    private int age;

    /* Mammal Constructors. */
    public Mammal(int animal_code, String animal_name, String animal_category, double animal_weight, int animal_age) {
        setAnimal_code(animal_code);
        setAnimal_name(animal_name);
        setAnimal_category(animal_category);
        setAnimal_weight(animal_weight);
        setAnimal_age(animal_age);
    }
    public Mammal() {}

    /* Getters and Setters for above fields. */
    public double getAnimal_weight() {
        return weight;
    }
    public void setAnimal_weight(double weight) {
        if (weight >= 0.015 && weight <= 181436.948) {
            this.weight = weight;
        }
    }
    public int getAnimal_age() {
        return age;
    }
    public void setAnimal_age(int age) {
        if (age > 0 && age < 211 ) {
            this.age = age;
        }
    }

    /* Overrides of Methods. */
    @Override
    public String toString() {
        return "Animal [Code=" + getAnimal_code() + ", Name=" + getAnimal_name() + ", Category=" + getAnimal_category() + ", Weight=" + getAnimal_weight() + ", Age=" + getAnimal_age() + "]";
    }
    @Override
    public void ICanEat() {
        System.out.println("I am a mammal and you can feed me!");
    }
}