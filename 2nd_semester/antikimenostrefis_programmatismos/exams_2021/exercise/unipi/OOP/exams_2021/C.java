package unipi.OOP.exams_2021;

import java.util.ArrayList;

public class C {
    // C's field
    private ArrayList list;

    // C's Constructor
    public C(ArrayList list) {
        this.list = list;
    }

    // Getter & Setter
    public ArrayList getList() {
        return list;
    }
    public void setList(ArrayList list) {
        this.list = list;
    }

    // Add Item to List
    public void addItemToList(IDoSomething item) {
        this.list.add(item);
    }

    // Count Items of List
    public int countItemsOfList() {
        return this.list.size();
    }

    // Print All Items
    public void printAllItems() {
        for (int i = 0; i < this.countItemsOfList(); i++) {
            System.out.println(this.list.get(i));
        }
    }
}
