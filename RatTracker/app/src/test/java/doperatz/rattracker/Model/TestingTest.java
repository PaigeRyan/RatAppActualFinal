package doperatz.rattracker.Model;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

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


    /**
     * Tests the compare method in DateRange
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDateRangeNull() {
        DateRange dateRange = new DateRange(1,1,1);
        dateRange.compare(null);
    }

    /**
     * Checks the constructor for the DateRange
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDateRangeNegative() {
        DateRange dateRange = new DateRange(-3423, -23423, 23434);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDateRangeIllegalMonth() {
        DateRange dateRange = new DateRange(2, 14, 2014);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDateRangeIllegalDay() {
        DateRange dateRange = new DateRange(32, 4, 2013);
    }

    @Test
    public void testUserEqualsNull() {
        boolean expctedValue = false;
        User user = new User("name", "password", true);
        assertFalse(user.equals(null));

    }

    @Test
    public void testUserEqualsNotUser() {
        boolean expctedValue = false;
        User user = new User("name", "password", true);
        boolean actual = user.equals(null);
        assertFalse(actual);

    }



}