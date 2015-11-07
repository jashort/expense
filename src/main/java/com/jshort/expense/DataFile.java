package com.jshort.expense;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class DataFile {
    private Path filePath;
    private static final Charset charset = Charset.forName("UTF8");
    private static final String fileHeader = "Date\tCategory\tItem\tCost";

    // Because this utility usually opens the data file, does one thing, then
    // closes, don't bother keeping the file open - just read or write it and
    // close it.

    public DataFile() {
        this(System.getProperty("user.home") + "/.clexp/data.csv");
    }

    public DataFile(String filename) {
        this.filePath = Paths.get(filename);
    }

    public List<Expense> readAll() throws IOException {
        List<Expense> expenseList = new ArrayList<Expense>();

        try (BufferedReader reader = Files.newBufferedReader(filePath, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (!line.equals(fileHeader)) {
                    expenseList.add(new Expense(line));
                }
            }
        } catch (IOException e) {
            throw new IOException("File not found: " + filePath);
        }
        return expenseList;
    }

    public void appendExpense(Expense expense) throws IOException {
        // Create directory and data file if it doesn't exist
        boolean newFile = false;
        if (Files.notExists(filePath.getParent())) {
            Files.createDirectories(filePath.getParent());
        }
        if (Files.notExists(filePath)) {
            Files.createFile(filePath);
            newFile = true;
        }

        String s = String.format("%s%n", expense.toString());
        try (BufferedWriter writer = Files.newBufferedWriter(filePath, charset, StandardOpenOption.APPEND)) {
            if (newFile) { writer.write(String.format("%s%n", fileHeader)); }
            writer.write(s, 0, s.length());
        } catch (IOException e) {
            throw new IOException("File not found: " + filePath);
        }
    }

    public Path getFilePath() { return filePath; }

}
