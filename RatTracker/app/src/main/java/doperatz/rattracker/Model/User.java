package doperatz.rattracker.Model;

/**
 * Created by agysc on 9/23/2017.
 */

public class User {
    private String _name;
    private String _password;


    public User(String name, String password) {
        _name = name;
        _password = password;
    }

    public String get_password() {
        return _password;
    }
    public void set_password(String _password) {
        this._password = _password;
    }



    public String getName() {
        return _name;
    }
    public void setName(String name) {
        _name = name;
    }

    /**
     *
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
     * to check eqaulity based on the
     * Users's username and
     * password
     *
     * @param o The user your want to
     *          pass in
     * @return If the two users are equal
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof User)) {
            return false;
        }

        if ((((User) o)._name.equals(_name)) && ((User) o)._password.equals(_password)) {
            return true;
        } else {
            return false;
        }
    }



}
