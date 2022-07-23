import java.util.*;

public class Products {

    private final List<Product> productsList = new ArrayList<>();

    public void addProduct(String productLine){
        String[] separated = productLine.strip().split(" ");
        UUID uuid = UUID.randomUUID();
        Product product = new Product(uuid.toString(), separated[0], Integer.parseInt(separated[1]));
        productsList.add(product);
    }

    public boolean deleteProduct(String id){
        for (Product product: productsList){
            if (product.getId().equals(id)) {
                productsList.remove(product);
                return true;
            }
        }
        return false;
    }

    public void displayAllProducts(){
        for (Product product: productsList){
            System.out.println(product.toString());
        }
    }

}
