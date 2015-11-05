package com.jshort.expense.validation;

import com.jshort.expense.validation.ArgumentException;
import com.jshort.expense.validation.ArgumentValidator;
import junit.framework.TestCase;

public class ArgumentValidatorTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    public void testEmptyArguments() throws Exception {
        try {
            String[] args = {};
            ArgumentValidator a = new ArgumentValidator(args);
        }
        catch (ArgumentException e) {
            return;
        }
        fail("ArgumentValidator did not fail when no arguments were present");
    }

    public void testGetCommand() throws Exception {
        String[] args = {"list"};
        ArgumentValidator a = new ArgumentValidator(args);
        assertEquals("list", a.getCommand());
    }

    public void testCommandChangedToLowercase() throws Exception {
        String[] args = {"LIST"};
        ArgumentValidator a = new ArgumentValidator(args);
        assertEquals("list", a.getCommand());
    }


}