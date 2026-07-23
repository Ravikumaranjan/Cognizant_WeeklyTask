import java.util.HashMap;
import java.util.Map;

// Product Class
class Product {

    private int productId;
    private String productName;
    private int quantity;
    private double price;

    // Constructor
    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getter Methods
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    // Setter Methods
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Display Product Details
    @Override
    public String toString() {
        return "Product ID : " + productId +
                "\nProduct Name : " + productName +
                "\nQuantity : " + quantity +
                "\nPrice : ₹" + price;
    }
}

// Inventory Management Class
class Inventory {

    private HashMap<Integer, Product> inventory = new HashMap<>();

    // Add Product
    public void addProduct(Product product) {

        if (inventory.containsKey(product.getProductId())) {
            System.out.println("Product already exists.");
        } else {
            inventory.put(product.getProductId(), product);
            System.out.println("Product added successfully.");
        }
    }

    // Update Product
    public void updateProduct(int id, String name, int quantity, double price) {

        if (inventory.containsKey(id)) {

            Product p = inventory.get(id);

            p.setProductName(name);
            p.setQuantity(quantity);
            p.setPrice(price);

            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete Product
    public void deleteProduct(int id) {

        if (inventory.containsKey(id)) {
            inventory.remove(id);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Display Inventory
    public void displayProducts() {

        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("\nInventory Details\n");

        for (Map.Entry<Integer, Product> entry : inventory.entrySet()) {

            System.out.println(entry.getValue());
            System.out.println("-------------------------");
        }
    }
}

// Main Class
public class exercise_1_inventory_mag_sys {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        Product p1 = new Product(101, "Laptop", 10, 65000);
        Product p2 = new Product(102, "Keyboard", 30, 1200);
        Product p3 = new Product(103, "Mouse", 25, 800);

        // Add Products
        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);

        // Display Products
        inventory.displayProducts();

        // Update Product
        inventory.updateProduct(102, "Mechanical Keyboard", 20, 2500);

        // Delete Product
        inventory.deleteProduct(103);

        // Display Again
        System.out.println("\nAfter Update and Delete\n");
        inventory.displayProducts();
    }
}