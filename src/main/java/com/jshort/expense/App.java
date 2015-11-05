package com.jshort.expense;

import com.jshort.expense.validation.ArgumentException;
import com.jshort.expense.validation.ArgumentValidator;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("Hello World");
        ArgumentValidator arguments;
        try {
            arguments = new ArgumentValidator(args);
            System.out.println(arguments.getCommand());
        } catch (ArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }

        LocalDate d = LocalDate.parse("09/15/1979", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(d);

        Expense c = new Expense("09/15/1979\tFun\tfun\t$32.21");
        System.out.println(c);

    }
}
