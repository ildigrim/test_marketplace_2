import java.util.Random;

public class Products {

    String[][] products = new String[2][5];

    public void addProduct(String product){
        String[] separated = product.strip().split(" ");
        Random rand = new Random();
        if (separated.length == 2) {
            for (int i = 0; i < 3; i++){
                if (products[0][i].equals("")){
                    int getID = rand.nextInt();
                    products[0][i] = String.valueOf(getID);
                    products[1][i] = separated[0];
                    products[2][i] = separated[1];
                    break;
                }
                else {
                    if (i == 2) {
                        System.out.println("Can't add a new product. List of products is full.");
                    }
                }
            }
        }
        else {
            System.out.println("Wrong product data format.");
        }
    }

    public void deleteProduct(int id){
        boolean isProductExists = true;
        for (int i = 0; i < 5; i++) {
            if (id == Integer.parseInt(products[0][i])){
                for (int j = 0; j < 2; j++) {
                    products[j][i] = "";
                }
            }
            else isProductExists = false;
        }
        if (!isProductExists) System.out.println("Product with that ID does not exists.");
    }

}
