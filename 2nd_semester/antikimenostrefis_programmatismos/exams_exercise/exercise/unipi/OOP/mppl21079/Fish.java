package unipi.OOP.mppl21079;

import java.io.Serializable;

public class Fish extends Animal implements Feed, Serializable {
    /* Some specific fields of Fish. */
    private double weight;
    private int age;

    /* Fish Constructors. */
    public Fish(int animal_code, String animal_name, String animal_category, double animal_weight, int animal_age) {
        setAnimal_code(animal_code);
        setAnimal_name(animal_name);
        setAnimal_category(animal_category);
        setAnimal_weight(animal_weight);
        setAnimal_age(animal_age);
    }
    public Fish() {};

    /* Getters and Setters for above fields. */
    public double getAnimal_weight() {
        return weight;
    }
    public void setAnimal_weight(double weight) {
        if (weight >= 0.012 && weight <= 2000) {
            this.weight = weight;
        }
    }
    public int getAnimal_age() {
        return age;
    }
    public void setAnimal_age(int age) {
        if (age > 0 && age < 40 ) {
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
        System.out.println("I am a fish and you can feed me!");
    }
}