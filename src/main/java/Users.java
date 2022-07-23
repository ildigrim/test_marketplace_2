import java.util.*;

public class Users {

    private final List<User> usersList = new ArrayList<>();

    public void addUser(String userLine){
        String[] separated = userLine.strip().split(" ");
        UUID uuid = UUID.randomUUID();
        User user = new User(uuid.toString(), separated[0], separated[1], Integer.parseInt(separated[2]));
        usersList.add(user);
    }

    public boolean deleteUser(String  id){

        for (User user: usersList){
            if (user.getId().equals(id)) {
                usersList.remove(user);
                return true;
            }
        }
        return false;
    }

    public void displayAllUsers(){
        for (User user: usersList){
            System.out.println(user.toString());
        }
    }

}
