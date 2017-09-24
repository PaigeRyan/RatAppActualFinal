package doperatz.rattracker.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agysc on 9/24/2017.
 */

public class Model {
    //Singleton instance
    private static final Model _instance = new Model();
    public static Model getInstance() {
        return _instance;
    }

    //list of Users in the system
    private List<User> _users;


    //Constructor
    private Model() {
        _users = new ArrayList<User>();
        loadDefaultData();
    }

    /*
    Hard Coded user with
    username: user
    password: password
    Just for this milestone
     */
    private void loadDefaultData() {
        _users.add(new User("user", "pass"));
    }

    /**
     * Checks to see if the user exists in the system
     * using the users data
     *
     * @param username the users username
     * @param password the users passwrod
     * @return If it exists in the system
     */
    public boolean isUser(String username, String password) {
        if (_users.contains(new User(username, password))) {
            return true;
        } else  {
            return false;
        }
    }

    /**
     * checks to see if the user exists in the system
     * using a user object
     *
     * @param user the user your looking for
     * @return if the user exists in the system
     */
    public boolean isUser(User user) {
        if (_users.contains(user)) {
            return true;
        } else  {
            return false;
        }
    }

    /**
     * Adds a user
     *
     * @param user to be added
     */
    public void addUser(User user) {
        _users.add(user);
    }

    /**
     * Adds a user using user properties
     *
     * @param name the user's name
     * @param password the user's password
     */
    public void addUser(String name, String password) {
        _users.add(new User(name, password));
    }



}
