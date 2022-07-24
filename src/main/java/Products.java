import java.util.*;

public class Products {

    public static final List<Product> productsList = new ArrayList<>();

    public static void addProduct(String productLine){
        String[] separated = productLine.strip().split(" ");
        UUID uuid = UUID.randomUUID();
        Product product = new Product(uuid.toString(), separated[0], Integer.parseInt(separated[1]));
        productsList.add(product);
    }

    public static Product getProduct(String productID) {
        for (Product product: productsList){
            if (product.getId().equals(productID)) {
                return product;
            }

        }
        return null;
    }

    public static boolean deleteProduct(String productID){
        Users.removeProduct(productID);
        for (Product product: productsList){
            if (product.getId().equals(productID)) {
                productsList.remove(product);
                return true;
            }
        }
        return false;
    }

    public static void displayAllProducts(){
        for (Product product: productsList){
            System.out.println(product.toString());
        }
    }

}
