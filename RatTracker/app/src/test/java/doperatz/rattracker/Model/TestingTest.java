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

    //Paige's JUnit tests for checkPassword
    @Test
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
    @Test
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


    /**
     *  Tests user equals method
     *  Rachel's JUNIT tests
     */
    @Test
    public void testUserEqualsNull() {
        User user = new User("name", "password", true);
        assertFalse(user.equals(null));
    }

    @Test
    public void testUserEqualsNotUser() {
        User user = new User("name", "password", true);
        User otherUser = new User("otherName", "password", true);
        User anotherUser = new User("name", "otherPass", true);
        User yetAnotherUser = new User("name", "password", false);
        assertFalse(user.equals(otherUser));
        assertFalse(user.equals(anotherUser));
        assertFalse(user.equals(yetAnotherUser));
    }



    /**
     * Tests the compare method in DateRange
     * Ethan's JUNIT Tests
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDateRangeNull() {
        DateRange dateRange = new DateRange(1,1,1);
        dateRange.compare(null);
    }

    @Test
    public void testDateRangeEquals() {
        DateRange dateRange1 = new DateRange(1, 20, 98);
        DateRange dateRange2 = new DateRange(1, 20, 98);
        assertEquals(0, dateRange1.compare(dateRange2));
    }

    @Test
    public void testDateRangeLesser() {
        DateRange dateRange1 = new DateRange(3, 20, 98);
        DateRange dateRange2 = new DateRange(1, 20, 98);
        assertTrue(dateRange1.compare(dateRange2) < 0);
    }

    @Test
    public void testDateRangeGreater() {
        DateRange dateRange1 = new DateRange(1, 20, 98);
        DateRange dateRange2 = new DateRange(3, 20, 98);
        assertTrue(dateRange1.compare(dateRange2) > 0);
    }

    /**
     * Checks the constructor for the DateRange
     * Andrew's JUNIT Tests
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



    //Rachel's JUnit Tests for

}