import java.util.Scanner;

public class Marketplace {

    public static void displayMenu(){
        System.out.println("1 - show users");
        System.out.println("2 - show products");
        System.out.println("3 - add user");
        System.out.println("4 - delete user");
        System.out.println("5 - add product");
        System.out.println("6 - delete product");
        System.out.println("0 - exit");
    }


    public static void main(String[] args) {
        boolean exitCondition = true;
        Scanner scanner = new Scanner(System.in);
        Users users = new Users();
        Products products = new Products();

        while (exitCondition) {
            displayMenu();
            int index = scanner.nextInt();
            switch (index) {
                case 0: exitCondition = false;
                case 1:
                    users.displayAllUsers();
                    break;
                case 2:
                    products.displayAllProducts();
                    break;
                case 3:
                    System.out.println("Please enter user data splitted up by spaces according to format: \n" +
                            "\"FirstName LastName MoneyAmount\"");
                    users.addUser(scanner.nextLine().strip());
                case 4:
                    System.out.println("Please enter user ID to delete.");
                    users.deleteUser(scanner.nextLine().strip());
                case 5:
                    System.out.println("Please enter product data splitted up by spaces according to format: \n" +
                            "\"ProductName Price\"");
                    products.addProduct(scanner.nextLine().strip());
                case 6:
                    System.out.println("Please enter product ID to delete.");
                    products.deleteProduct(scanner.nextLine().strip());
                default: displayMenu();
            }
        }
    }
}
