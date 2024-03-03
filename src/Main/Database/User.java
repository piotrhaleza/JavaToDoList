package Main.Database;


//This class is going to be moved to the API later on
public class User {

    int id;
    String username;

    //necessary empty constructor
    public User(){}
    protected User(int id, String username){
        this.id = id;
        this.username = username;
    }
}
