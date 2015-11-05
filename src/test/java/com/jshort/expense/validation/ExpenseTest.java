package com.jshort.expense.validation;

import com.jshort.expense.Expense;
import junit.framework.TestCase;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by jason on 11/5/15.
 */
public class ExpenseTest extends TestCase {

    public void testParseDataString() throws Exception {
        Expense c = new Expense("9/15/2015\tGroceries\tgroceries\t$24.99");
        assertEquals(LocalDate.of(2015, 9, 15), c.getDate());
        assertEquals("Groceries", c.getCategory());
        assertEquals("groceries", c.getDescription());
        assertEquals(BigDecimal.valueOf(24.99), c.getCost());
    }

    public void testToString() throws Exception {
        Expense c = new Expense("9/15/2015\tGroceries\tgroceries\t$24.99");
        assertEquals("9/15/2015\tGroceries\tgroceries\t$24.99", c.toString());
    }

    public void testSetCategory() throws Exception {

    }

    public void testSetCost() throws Exception {

    }
}