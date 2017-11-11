package doperatz.rattracker.Model;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.rules.ExpectedException;

public class TestingTest {

    public static final int TIMEOUT = 200;
    Model model = Model.getInstance();

    //Paige's JUnit Tests for checkPassword
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    public void testCheckPasswordException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("User cannot be null.");
        model.checkPassword(null);
    }

    @Test(timeout = TIMEOUT)
    public void testCheckPassword() {
        User u1 = new User("Paige", "password", true);
        User u2 = new User("Paige", "notPassword", true);
        model.addUser(u1);

        assertTrue(model.checkPassword(u1));
        assertFalse(model.checkPassword(u2));
    }

    //Josh's JUnit Tests for isUser
    public void testIsUserException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("User cannot be null.");
        model.isUser(null);
    }

    @Test(timeout = TIMEOUT)
    public void testIsUser() {
        User there = new User("Josh", "myPass", false);
        User notThere = new User("Bob", "hjkauf", false);
        model.addUser(there);

        assertTrue(model.isUser(there));
        assertFalse(model.isUser(notThere));
    }
}