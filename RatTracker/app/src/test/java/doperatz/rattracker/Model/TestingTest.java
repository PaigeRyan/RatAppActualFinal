package doperatz.rattracker.Model;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.rules.ExpectedException;

public class TestingTest {

    public static final int TIMEOUT = 200;
    Model model = Model.getInstance();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    //Paige's JUnit Tests for checkPassword

    public void testCheckPasswordException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("User cannot be null.");
        model.checkPassword(null);
    }

    @Test(timeout = TIMEOUT)
    public void testCheckPassword() {
        
    }
}