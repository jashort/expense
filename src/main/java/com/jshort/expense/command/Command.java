package com.jshort.expense.command;

import com.jshort.expense.Expense;
import com.jshort.expense.validation.ArgumentValidator;
import java.util.List;

public interface Command {
    String run(List<Expense> expenseList, ArgumentValidator args);
    String getDescription();

}
