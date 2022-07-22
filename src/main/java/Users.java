import java.util.Random;

public class Users {

    String[][] users = new String[3][5];
    int usersCount = 0;

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

    public void deleteUser(){

    }

    public void usersStorage(){

    }


}
