public class InventoryManagementSystem{
    public static void main(String[] args){
        Inventory inventory=new Inventory();

        inventory.addProduct(new Product(101,"Laptop",10,55000));
        inventory.addProduct(new Product(102,"Mouse",50,500));
        inventory.addProduct(new Product(103,"Keyboard",20,1200));

        inventory.displayProducts();

        inventory.updateProduct(102,60,550);
        inventory.displayProducts();

        inventory.deleteProduct(103);
        inventory.displayProducts();

        System.out.println("\nTime Complexity:");
        System.out.println("Add    : O(1)");
        System.out.println("Update : O(1)");
        System.out.println("Delete : O(1)");
        System.out.println("Optimization: HashMap provides fast lookup using keys.");
    }
}
