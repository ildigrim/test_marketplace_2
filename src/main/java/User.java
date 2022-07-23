public class User {
    private String id;
    private String name;
    private String lastName;
    private int money;

    public User(String id, String name, String lastName, int money){
        setId(id);
        setName(name);
        setLastName(lastName);
        setMoney(money);
    }

    public String toString(){
        return id + " " + name + " " + lastName + " " + money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

}
