package com.jshort.expense;

import com.jshort.expense.command.ListExpenses;
import com.jshort.expense.validation.ArgumentException;
import com.jshort.expense.validation.ArgumentValidator;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("Hello World");
        ArgumentValidator arguments = new ArgumentValidator();
        try {
            arguments = new ArgumentValidator(args);
            System.out.println(arguments.getCommand());
        } catch (ArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }

        DataFile df = new DataFile();
        List<Expense> expenses = new ArrayList<>();
        try {
            expenses = df.readAll();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Expense e = new Expense();
        e.setCategory("Fun");
        e.setDescription("Stuff");
        e.setDate("05/19/2015");
        e.setCost("$23.35");
        try {
            df.appendExpense(e);
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        System.out.println(new ListExpenses().run(expenses, arguments));

    }
}
