// Human-written solution. Task: simple inventory system
// (add item, remove item, update quantity, search, and print a low-stock report).

import java.util.ArrayList;
import java.util.List;

public class task06_inventory_system {

    static final int LOW_STOCK_LIMIT = 5;

    static class Item {
        String name;
        int quantity;
        double price;

        Item(String name, int quantity, double price) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }
    }

    static List<Item> items = new ArrayList<>();

    static Item find(String name) {
        for (Item item : items) {
            if (item.name.equals(name)) {
                return item;
            }
        }
        return null;
    }

    static void add(String name, int qty, double price) {
        Item item = find(name);
        if (item == null) {
            items.add(new Item(name, qty, price));
        } else {
            item.quantity += qty;
            item.price = price;
        }
    }

    static void remove(String name, int qty) {
        Item item = find(name);
        if (item != null) {
            item.quantity = Math.max(0, item.quantity - qty);
        }
    }

    static void update(String name, int qty, double price) {
        Item item = find(name);
        if (item != null) {
            item.quantity = qty;
            item.price = price;
        }
    }

    static void search(String name) {
        Item item = find(name);
        if (item != null) {
            System.out.println(name + " qty=" + item.quantity + " price=" + item.price);
        } else {
            System.out.println("Item not found: " + name);
        }
    }

    static void report() {
        for (Item item : items) {
            if (item.quantity < LOW_STOCK_LIMIT) {
                System.out.println("LOW STOCK: " + item.name + " (" + item.quantity + ")");
            }
        }
    }

    public static void main(String[] args) {
        add("apple", 10, 2.5);
        add("banana", 3, 1.0);
        remove("apple", 7);
        update("banana", 2, 1.2);
        search("apple");
        report();
    }
}
