package com.jshort.expense.validation;

import java.util.Arrays;
import java.util.List;

/**
 * Parse arguments and convert to the proper types
 */
public class ArgumentValidator {
    private static final List<String> validCommands = Arrays.asList("add", "list", "total", "totals", "summary", "help");

    private String command = null;

    public ArgumentValidator(String[] arguments) throws ArgumentException {
        if (arguments.length < 1) { throw new ArgumentException("No command line arguments"); }

        if (!validCommands.contains(arguments[0].toLowerCase())) {
            throw new ArgumentException("Valid commands are: " + validCommands.toString());
        } else {
            command = arguments[0].toLowerCase();
        }


    }

    public String getCommand() { return command; }

}
