// AI-generated solution. Task: simple inventory system
// (add item, remove item, update quantity, search, and print a low-stock report).

import java.util.ArrayList;
import java.util.List;

public class task06_inventory_system {

    static List<String> names = new ArrayList<String>();
    static List<Integer> quantities = new ArrayList<Integer>();
    static List<Double> prices = new ArrayList<Double>();

    public static void processInventory(String command, String name, int qty, double price) {
        if (command != null) {
            if (command.equals("ADD")) {
                boolean found = false;
                for (int i = 0; i < names.size(); i++) {
                    if (names.get(i).equals(name)) {
                        found = true;
                        int current = quantities.get(i);
                        current = current + qty;
                        quantities.set(i, current);
                        if (price > 0) {
                            prices.set(i, price);
                        }
                    }
                }
                if (found == false) {
                    names.add(name);
                    quantities.add(qty);
                    prices.add(price);
                    System.out.println("Added new item: " + name);
                } else {
                    System.out.println("Updated existing item: " + name);
                }
            } else if (command.equals("REMOVE")) {
                boolean found = false;
                for (int i = 0; i < names.size(); i++) {
                    if (names.get(i).equals(name)) {
                        found = true;
                        int current = quantities.get(i);
                        current = current - qty;
                        if (current < 0) {
                            current = 0;
                        }
                        quantities.set(i, current);
                        System.out.println("Removed " + qty + " of " + name);
                    }
                }
                if (found == false) {
                    System.out.println("Item not found: " + name);
                }
            } else if (command.equals("UPDATE")) {
                boolean found = false;
                for (int i = 0; i < names.size(); i++) {
                    if (names.get(i).equals(name)) {
                        found = true;
                        quantities.set(i, qty);
                        if (price > 0) {
                            prices.set(i, price);
                        }
                        System.out.println("Updated " + name);
                    }
                }
                if (found == false) {
                    System.out.println("Item not found: " + name);
                }
            } else if (command.equals("SEARCH")) {
                boolean found = false;
                for (int i = 0; i < names.size(); i++) {
                    if (names.get(i).equals(name)) {
                        found = true;
                        System.out.println(name + " qty=" + quantities.get(i)
                                + " price=" + prices.get(i));
                    }
                }
                if (found == false) {
                    System.out.println("Item not found: " + name);
                }
            } else if (command.equals("REPORT")) {
                for (int i = 0; i < names.size(); i++) {
                    if (quantities.get(i) < 5) {
                        System.out.println("LOW STOCK: " + names.get(i)
                                + " (" + quantities.get(i) + ")");
                    }
                }
            } else {
                System.out.println("Unknown command");
            }
        }
    }

    public static void main(String[] args) {
        processInventory("ADD", "apple", 10, 2.5);
        processInventory("ADD", "banana", 3, 1.0);
        processInventory("REMOVE", "apple", 7, 0);
        processInventory("UPDATE", "banana", 2, 1.2);
        processInventory("SEARCH", "apple", 0, 0);
        processInventory("REPORT", "", 0, 0);
    }
}
