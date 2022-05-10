package unipi.OOP.mathima5.serialization;

import java.io.*;

public class Demo {

    public static void main(String[] args) {
        // H serilize() φτιάχνει το αρχείο p.txt περνόντας μέσα το object p1
        Professor p1 = new Professor();
        p1.setName("Fotis");
        p1.setOfficeNumber(123);
        serilize(p1);

        // H deserialize() παίρνει το αρχείο p.txt, το διαβάζει, μετατρέπει το περιεχόμενο σε object, το περνάει στο object s2 και απο αυτό εκτυπώνουμε το όνομα του
        Professor p2 = deserialize("p.txt");
        System.out.println(p2.getName());
    }

    static void serilize(Professor p) {
        try {
            FileOutputStream fos = new FileOutputStream("p.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(p);
            oos.close();
            fos.close();
            System.out.println("Object has been serialized");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Professor deserialize(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Professor p = (Professor) ois.readObject();
            ois.close();
            fis.close();
            return p;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Θα επιστέψει αυτό σε περίπτωση που αποτύχει το "return p;". Το βάζω εδώ για να μην κάνω return μέσα σε κάθε catch.
        return null;
    }
}
