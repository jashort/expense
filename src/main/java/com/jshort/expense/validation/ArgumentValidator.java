package com.jshort.expense.validation;

import java.util.Arrays;
import java.util.List;

/**
 * Parse arguments and convert to the proper types
 */
public class ArgumentValidator {
    private static final List<String> validCommands = Arrays.asList("add", "list", "total", "totals", "summary", "help");

    private String command = null;
    private Integer year = null;
    private Integer month = null;

    public ArgumentValidator() {
        command = "help";
    }

    public ArgumentValidator(String[] arguments) throws ArgumentException {
        parse(arguments);
    }

    public void parse(String[] arguments) throws ArgumentException {
        if (arguments.length < 1) { throw new ArgumentException("No command line arguments"); }

        if (!validCommands.contains(arguments[0].toLowerCase())) {
            throw new ArgumentException("Valid commands are: " + validCommands.toString());
        } else {
            command = arguments[0].toLowerCase();
        }
    }

    public String getCommand() { return command; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    public Integer getMonth() { return month; }
    public void setMonth(Integer month) { this.month = month; }

    public boolean hasYear() { return this.year != null; }
    public boolean hasMonth() { return this.month != null; }
}
