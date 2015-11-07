package com.jshort.expense.command;

import com.jshort.expense.Expense;
import com.jshort.expense.validation.ArgumentValidator;
import java.util.List;

public class ListExpenses implements Command {

    @Override
    public String run(List<Expense> expenseList, ArgumentValidator args) {
        StringBuilder sb = new StringBuilder();

        for (Expense expense : expenseList) {
            if (!args.hasYear() || expense.getYear().equals(args.getYear())) {
                if (!args.hasMonth() || expense.getMonth().equals(args.getMonth())) {
                    sb.append(String.format("%s\t%s\t%40s\t%8s%n",
                            expense.getFormattedDate(), expense.getCategory(),
                            expense.getDescription(), expense.getFormattedCost()));
                }
            }
        }
        return sb.toString();
    }

    @Override
    public String getDescription() {
        return "ListExpenses All Expenses";
    }
}
