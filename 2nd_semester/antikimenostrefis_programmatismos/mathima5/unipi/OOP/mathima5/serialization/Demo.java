package unipi.OOP.mathima5.serialization;

import java.io.*;

public class Demo {
    public static void main(String[] args) {
        // Use serialize() method.
        Professor p1 = new Professor(1234, "Fotis");
        serialize(p1);

        // Use deserialize() method.
        Professor p2 = deserialize("p.txt");
        System.out.println("Professor Name: "+p2.getName()+", Professor Office Number: "+p2.getOfficeNumber());
    }

    // Serialization is a mechanism of converting the state of an object into a byte stream.
    static void serialize(Professor p) {
        try {
            // Saving of object in a file.
            FileOutputStream file = new FileOutputStream("p.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);
            // Method for serialization of object.
            out.writeObject(p);
            // Close file and out objects.
            out.close();
            file.close();
            // Print success message.
            System.out.println("Object has been serialized");
        } catch (IOException e) {
            // Exception error for writeObject() method of ObjectOutputStream class
            e.printStackTrace();
        }
    }

    // Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory.
    static Professor deserialize(String filename) {
        try {
            // Reading the object from a file.
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            // Method for deserialization of object
            Professor p = (Professor) in.readObject();
            // Close file and in objects.
            in.close();
            file.close();
            // Print success message and return object.
            System.out.println("Object has been deserialized");
            return p;
        } catch (IOException e) {
            // Exception error for readObject() method of ObjectInputStream class.
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            // Exception error in case the "Professor" class wasn't found.
            e.printStackTrace();
            return null;
        }
    }
}
