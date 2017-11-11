package doperatz.rattracker.Model;

import java.util.Arrays;
import java.util.List;

public class User {
    private final String _name;
    private final String _password;
    private final boolean _isAdmin;
    public final static List<String> possibleUserTypes = Arrays.asList("Admin", "Basic User");

    public User(String name, String password, boolean isAdmin) {
        _name = name;
        _password = password;
        _isAdmin = isAdmin;
    }

    public User(String name, String password) {
        this(name, password, false);
    }

    public String get_password() {
        return _password;
    }

    /**
     * @return the name and password
     */
    @Override
    public String toString() {
        return "User{" +
                "_name='" + _name + '\'' +
                ", _password='" + _password + '\'' +
                '}';
    }

    /**
     * Overrides the equals method
     * to check equality based on the
     * Users's username
     *
     * @param o The user your want to
     *          pass in
     * @return If the two users are equal
     */
    @Override
    public boolean equals(Object o) {
        return (o != null && o instanceof User && ((User) o)._name.equals(_name));
    }






}
