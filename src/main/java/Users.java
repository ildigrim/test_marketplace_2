import java.util.Random;

public class Users {

    String[][] users = new String[3][5];

    public void addUser(String user){
        String[] separated = user.strip().split(" ");
        Random rand = new Random();
        if (separated.length == 3) {
            for (int i = 0; i < 4; i++){
                if (users[0][i].equals("")){
                    int getID = rand.nextInt();
                    users[0][i] = String.valueOf(getID);
                    users[1][i] = separated[0];
                    users[2][i] = separated[1];
                    users[3][i] = separated[2];
                    break;
                }
                else {
                    if (i == 3) {
                        System.out.println("Can't create a new user. List of user is full.");
                    }
                }
            }
        }
        else {
            System.out.println("Wrong user data format.");
        }
    }

    public void deleteUser(int id){
        boolean isUserExists = true;
        for (int i = 0; i < 5; i++) {
            if (id == Integer.parseInt(users[0][i])){
                for (int j = 0; j < 3; j++) {
                    users[j][i] = "";
                }
            }
            else isUserExists = false;
        }
        if (!isUserExists) System.out.println("User with that ID is not exists.");
    }

    public void displayAllUsers(){
        for(int i = 0; i < 5; i++){
            System.out.println(users[0][i] + " " + users[1][i] + " " + users[2][i] + " " + users[3][i]);
        }
    }

}
