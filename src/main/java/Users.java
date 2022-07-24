import java.util.*;

public class Users {

    private static final List<User> usersList = new ArrayList<>();
    private static final Map<String, List<Product>> userProductsMap = new HashMap<>();

    public static void purchase(String userID, String productID){
        Product product = Products.getProduct(productID);
        if (product == null){
            System.out.println("Product " + productID + " does not exists.");
            return;
        }
        User user = getUserByID(userID);
        if (user == null) {
            System.out.println("User does not exists.");
            return;
        }
        if (product.getPrice()>user.getMoney()){
            System.out.println("User has no much money.");
            return;
        }
        user.setMoney(user.getMoney()-product.getPrice());
        if (userProductsMap.containsKey(userID)){
            userProductsMap.get(userID).add(product);
        }
        else {
            List<Product> list = new ArrayList<>();
            list.add(product);
            userProductsMap.put(userID,list);
        }
    }

    public static void removeProduct(String productID){
        for (List<Product> productList: userProductsMap.values()) {
            for (Product product : productList) {
                if (product.getId().equals(productID)) {
                    productList.remove(product);
                }
            }
        }
    }

    public static String getUserProducts(String userID){
        if (userProductsMap.containsKey(userID)){
            StringBuilder res = new StringBuilder(userID + " :");
            for (Product product: userProductsMap.get(userID)){
                res.append(" ").append(product.getName());
            }
            return res.toString();
        }
        else {
            return "";
        }
    }

    public static String getProductOwners(String productID){
        StringBuilder res = new StringBuilder(productID + " :");
        boolean isBought = false;
        for (String userID: userProductsMap.keySet()){
            for (Product product: userProductsMap.get(userID)){
                if (product.getId().equals(productID)) {
                    res.append(" ").append(userID);
                    isBought = true;
                }
            }
        }
        if (isBought){
            return res.toString();
        }
        else return "";
    }

    public static void addUser(String userLine){
        String[] separated = userLine.strip().split(" ");
        UUID uuid = UUID.randomUUID();
        User user = new User(uuid.toString(), separated[0], separated[1], Integer.parseInt(separated[2]));
        usersList.add(user);
    }


    public static boolean deleteUser(String  id){

        for (User user: usersList){
            if (user.getId().equals(id)) {
                usersList.remove(user);
                return true;
            }
        }
        return false;
    }

    public static void displayAllUsers(){
        for (User user: usersList){
            System.out.println(user.toString());
        }
    }
    public static User getUserByID(String userID){
        for (User user: usersList) {
            if (user.getId().equals(userID)){
                return user;
            }
        }
        return null;
    }



}
