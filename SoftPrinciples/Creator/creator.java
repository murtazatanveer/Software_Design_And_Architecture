
import java.util.*;

 class shopingCart{

    // Order contains OrderItems.
    private ArrayList<item> items;

    shopingCart(){
        items=new ArrayList<>();
    }

    // Order is responsible for creating OrderItems
     void addItem(String productId, int quantity, String productName) {
        item newItem = new item(productId, quantity , productName);
        items.add(newItem);
    }

    void viewItems(){
        for (int i = 0; i < items.size(); i++) {
            System.out.println("Product Name : "+items.get(i).getproductName()+
            "\tProduct ID : "+items.get(i).getProductId()+"\tProduct Quantity : "+items.get(i).getQuantity());
        }
    }

}

class item {

    private String productName;
    private String productId;
    private int quantity;
    
    public item(String productId, int quantity , String productName) {
        this.productId = productId;
        this.quantity = quantity;
        this.productName=productName;
    }

    String getProductId(){
        return productId;
    }

    int getQuantity(){
        return this.quantity;
    }

    String getproductName(){
        return this.productName;
    }

}

public class creator {

    public static void main(String[] args) {
        
        shopingCart cart = new shopingCart();

        cart.addItem("100", 10, "Pepsi");
        cart.addItem("101", 20, "Bag");
        cart.addItem("102", 15, "Book");

        cart.viewItems();

    }
    
}
