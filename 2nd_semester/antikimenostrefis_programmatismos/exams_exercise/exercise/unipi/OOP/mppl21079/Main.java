package unipi.OOP.mppl21079;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    /* Main method. */
    public static void main(String[] args) {
        /* Terminal GUI for reaction with user. */
        while (true) {
            int num, choice4, choice5, choice6, animal_code, animal_age;
            String choice3, animal_name, animal_category;
            double animal_weight;
            System.out.println("Press 1 to display all animals.");
            System.out.println("Press 2 to add an animal.");
            System.out.println("Press 3 to search an animal by name.");
            System.out.println("Press 4 to search an animal by code.");
            System.out.println("Press 5 to delete an animal by code.");
            System.out.println("Press 6 to feed an animals by code.");
            System.out.println("Press 7 to exit.");
            System.out.println("Give a number:");
            Scanner scan = new Scanner(System.in);
            num = scan.nextInt();
            switch (num) {
                case 1 -> {
                    System.out.println("------------------------------------------------------------------------------");
                    printAllAnimals();
                    System.out.println("------------------------------------------------------------------------------");
                }
                case 2 -> {
                    System.out.println("------------------------------------------------------------------------------");
                    Scanner scan2 = new Scanner(System.in);
                    Scanner scan2_string = new Scanner(System.in);
                    Scanner scan2_double = new Scanner(System.in);
                    System.out.println("Give the animal code:");
                    animal_code = scan2.nextInt();
                    System.out.println("Give the animal name:");
                    animal_name = scan2_string.nextLine();
                    System.out.println("Give the animal category (mammal, reptilian, fish, bird):");
                    animal_category = scan2_string.nextLine();
                    System.out.println("Give the animal weight:");
                    animal_weight = scan2_double.nextDouble();
                    System.out.println("Give the animal age:");
                    animal_age = scan2.nextInt();
                    addAnAnimal(animal_code, animal_name, animal_category, animal_weight, animal_age);
                    System.out.println("------------------------------------------------------------------------------");
                }
                case 3 -> {
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.println("Give a name to find an animal.");
                    Scanner scan3 = new Scanner(System.in);
                    choice3 = scan3.nextLine();
                    printByName(choice3);
                    System.out.println("------------------------------------------------------------------------------");
                }
                case 4 -> {
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.println("Give a code to find an animal.");
                    Scanner scan4 = new Scanner(System.in);
                    choice4 = scan4.nextInt();
                    printByCode(choice4);
                    System.out.println("------------------------------------------------------------------------------");
                }
                case 5 -> {
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.println("Give a code to delete an animal.");
                    Scanner scan5 = new Scanner(System.in);
                    choice5 = scan5.nextInt();
                    deleteByCode(choice5);
                    System.out.println("------------------------------------------------------------------------------");
                }
                case 6 -> {
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.println("Give a code to feed an animal.");
                    Scanner scan6 = new Scanner(System.in);
                    choice6 = scan6.nextInt();
                    feedByCode(choice6);
                    System.out.println("------------------------------------------------------------------------------");
                }
                case 7 -> System.exit(0);
                default -> {
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.println("Wrong number! Please try again to enter a valid number.");
                    System.out.println("------------------------------------------------------------------------------");
                }
            }
        }
    }

    /* Declaration an ArrayList<Object>. */
    private static ArrayList<Object> animals = new ArrayList<>();

    /* Deserialization method. */
    static void deserialize() {
        try {
            FileInputStream fis = new FileInputStream("animalsData");
            ObjectInputStream ois = new ObjectInputStream(fis);
            animals = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* 1. Print all animals method */
    static void printAllAnimals() {
        deserialize();
        for (Object animal : animals) {
            System.out.println(animal.toString());
        }
        if (animals.isEmpty()) {
            System.out.println("The list is empty.");
        }
    }

    /* 2. Serialization method. */
    static void addAnAnimal(int animal_code, String animal_name, String animal_category, double animal_weight, int animal_age) {
        int count = 1;
        switch (animal_category) {
            case "mammal" -> animals.add(new Mammal(animal_code, animal_name, animal_category, animal_weight, animal_age));
            case "reptilian" -> animals.add(new Reptilian(animal_code, animal_name, animal_category, animal_weight, animal_age));
            case "fish" -> animals.add(new Fish(animal_code, animal_name, animal_category, animal_weight, animal_age));
            case "bird" -> animals.add(new Bird(animal_code, animal_name, animal_category, animal_weight, animal_age));
            default -> count = 0; // Wrong user's category input
        }
        if (count == 1) {
            try {
                FileOutputStream fos = new FileOutputStream("animalsData");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(animals);
                oos.close();
                fos.close();
                System.out.println("Animal has been serialized!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Wrong animal's category. Please try again.");
        }
    }

    /* 3. Deserialization method for search an animal by name. */
    static void printByName(String choice3) {
        deserialize();
        int count = 0;
        for (Object animal : animals) {
            if (animal.toString().contains("Name="+choice3+",")) {
                System.out.println(animal);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Wrong name. Please try again.");
        }
    }

    /* 4. Deserialization method for search an animal by code. */
    static void printByCode(int choice4) {
        deserialize();
        int count = 0;
        for (Object animal : animals) {
            if (animal.toString().contains("Code="+choice4+",")) {
                System.out.println(animal);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Wrong code. Please try again.");
        }
    }

    /* 5. Delete method by code. */
    static void deleteByCode(int choice5) {
        deserialize();
        int count = 0;
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).toString().contains("Code="+choice5+",")) {
                animals.remove(animals.get(i));
                count++;
                try {
                    FileOutputStream fos = new FileOutputStream("animalsData");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(animals);
                    oos.close();
                    fos.close();
                    System.out.println("Animal with code "+choice5+" has been removed!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (count == 0) {
            System.out.println("Wrong code. Please try again.");
        }
    }

    /* 6. Feed method by code. */
    static void feedByCode(int choice6) {
        deserialize();
        int count = 0;
        for (Object animal : animals) {
            if (animal.toString().contains("Code="+choice6+",")) {
                count++;
                if (animal.toString().contains("Category=mammal,")) {
                    Mammal m = new Mammal();
                    m.ICanEat();
                } else if (animal.toString().contains("Category=reptilian,")) {
                    Reptilian r = new Reptilian();
                    r.ICanEat();
                } else if (animal.toString().contains("Category=fish,")) {
                    Fish f = new Fish();
                    f.ICanEat();
                } else if (animal.toString().contains("Category=bird,")) {
                    Bird b = new Bird();
                    b.ICanEat();
                }
            }
        }
        if (count == 0) {
            System.out.println("Wrong code. Please try again.");
        }
    }
}