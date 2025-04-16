package SoftPrinciples.Information_Expert;

import java.util.ArrayList;

class Item {
    private String name;
    private double price;
    private int quantity;

    Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    double getPrice() { return price; }
    int getQuantity() { return quantity; }
    String getName() {return name;}
    
    
}

class ShoppingCart {
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    void viewItems(){
        for (int i = 0; i < items.size(); i++) {
            System.out.println("Product Name : "+items.get(i).getName()+
            "\tProduct Prce : "+items.get(i).getPrice()+"\tProduct Quantity : "+items.get(i).getQuantity());
        }
    }

    /*  Information Expert: ShoppingCart calculates the total. If i create extra class for perfrming
     this calculation then this create coupling between classes and also this method is also realted
     to this class. Assigns responsibility (calculateTotal) to this class because this class has the
     most information needed to fulfill it. */
     
    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}

public class informationExpert {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Laptop", 1000, 45));
        cart.addItem(new Item("Mouse", 20, 55));

        System.out.println("Total: $" + cart.calculateTotal()); 
    }
}
