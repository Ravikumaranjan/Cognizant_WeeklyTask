import java.util.HashMap;

public class Inventory {
    private HashMap<Integer,Product> products=new HashMap<>();

    public void addProduct(Product p){
        products.put(p.productId,p);
        System.out.println("Product Added");
    }

    public void updateProduct(int id,int qty,double price){
        if(products.containsKey(id)){
            Product p=products.get(id);
            p.quantity=qty;
            p.price=price;
            System.out.println("Product Updated");
        }else{
            System.out.println("Product Not Found");
        }
    }

    public void deleteProduct(int id){
        if(products.remove(id)!=null)
            System.out.println("Product Deleted");
        else
            System.out.println("Product Not Found");
    }

    public void displayProducts(){
        System.out.println("\nInventory:");
        for(Product p:products.values())
            System.out.println(p);
    }
}
