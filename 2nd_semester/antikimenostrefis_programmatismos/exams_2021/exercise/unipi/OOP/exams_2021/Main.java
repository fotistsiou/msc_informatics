package unipi.OOP.exams_2021;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // 'A' class instance
	    A a1 = new A("Hello World from a1", 1, true, "A1");
        System.out.println(a1.doSomething(1));
        A a2 = new A("Hello World from a2", 2, true, "A2");
        System.out.println(a2.doSomething(2));
        A a3 = new A("Hello World from a3", 3, true, "A3");
        System.out.println(a3.doSomething(3));

        // 'B' class instance
        String[] stringofListforb1 = {"str1", "str2", "str3"};
        B b1 = new B("Hello World from b1", 1, true, 12345, stringofListforb1);
        System.out.println(b1.doSomething(1));
        String[] stringofListforb2 = {"str4", "str5", "str6"};
        B b2 = new B("Hello World from b2", 2, true, 23456, stringofListforb2);
        System.out.println(b2.doSomething(2));
        String[] stringofListforb3 = {"str7", "str8", "str9"};
        B b3 = new B("Hello World from b3", 3, true, 34567, stringofListforb3);
        System.out.println(b3.doSomething(3));

        // 'C' class instance
        ArrayList myList = new ArrayList();
        C c = new C (myList);

        // Add Objects to List and Print
        c.addItemToList(a1);
        c.addItemToList(a2);
        c.addItemToList(a3);
        c.addItemToList(b1);
        c.addItemToList(b2);
        c.addItemToList(b3);
        System.out.println("The list has " + c.countItemsOfList() + " items:");
        c.printAllItems();
    }
}
