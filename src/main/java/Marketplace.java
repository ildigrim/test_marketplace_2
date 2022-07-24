import java.util.Scanner;

public class Marketplace {

    public static void displayMenu(){
        System.out.println("1 - show users");
        System.out.println("2 - show products");
        System.out.println("3 - add user");
        System.out.println("4 - delete user");
        System.out.println("5 - add product");
        System.out.println("6 - delete product");
        System.out.println("7 - purchase product");
        System.out.println("8 - display list of products by user");
        System.out.println("9 - display list of product owners");
        System.out.println("0 - exit");
    }



    public static void main(String[] args) {
        boolean exitCondition = true;
        Scanner scanner = new Scanner(System.in);

        while (exitCondition) {

            displayMenu();
            if (!scanner.hasNextInt()) {
                scanner.next();
                continue;
            }


            int index = scanner.nextInt();

            String line = scanner.nextLine();

            switch (index) {
                case 0: exitCondition = false;
                case 1:
                    Users.displayAllUsers();
                    break;
                case 2:
                    Products.displayAllProducts();
                    break;
                case 3:
                    System.out.println("Please enter user data splitted up by spaces according to format: " +
                            "\"FirstName LastName MoneyAmount\"");
                    Users.addUser(scanner.nextLine().strip());
                    break;
                case 4:
                    System.out.println("Please enter user ID to delete.");
                    Users.deleteUser(scanner.nextLine().strip());
                    break;
                case 5:
                    System.out.println("Please enter product data splitted up by spaces according to format: \n" +
                            "\"ProductName Price\"");
                    Products.addProduct(scanner.nextLine().strip());
                    break;
                case 6:
                    System.out.println("Please enter product ID to delete.");
                    Products.deleteProduct(scanner.nextLine().strip());
                    break;
                case 7:
                    System.out.println("Enter user's and product's id");
                    String[] splitter = scanner.nextLine().strip().split(" ");
                    Users.purchase(splitter[0], splitter[1]);
                    break;
                case 8:
                    System.out.println("Enter user ID");
                    System.out.println(Users.getUserProducts(scanner.nextLine().strip()));
                    break;
                case 9:
                    System.out.println("Enter product ID");
                    System.out.println(Users.getProductOwners(scanner.nextLine().strip()));
                    break;
                default: displayMenu();
            }
        }
        scanner.close();
    }
}
