package com.jshort.expense;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Expense {
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");

    private LocalDate date;
    private String category;
    private String description;
    private BigDecimal cost;

    public Expense() {}
    public Expense(String line) {
        // Used for reading from the data file. Could be refactored in to a separate parser
        String[] parts = line.split("\\t", -1);
        if (parts.length == 4) {
            setDate(parts[0]);
            setCategory(parts[1]);
            setDescription(parts[2]);
            setCost(parts[3]);
        }
    }

    public LocalDate getDate() { return date; }
    public String getFormattedDate() { return date.format(dateFormat); }
    public void setDate(LocalDate date) { this.date = date; }
    public void setDate(String date) { this.date = LocalDate.parse(date, dateFormat); }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getCost() { return cost; }
    public String getFormattedCost() { return "$" + cost.toString(); }
    public void setCost(BigDecimal cost) { this.cost = cost; }
    public void setCost(String cost) {
        // Todo: This doesn't handle different locales.
        cost = cost.replace("$", "");
        this.cost = new BigDecimal(cost);
    }

    public Integer getYear() {
        if (this.date != null) {
            return this.date.getYear();
        } else {
            return null;
        }
    }

    public Integer getMonth() {
        if (this.date != null) {
            return this.date.getMonthValue();
        } else {
            return null;
        }
    }

    public String toString() {
        return String.format("%s\t%s\t%s\t%s", getFormattedDate(), getCategory(), getDescription(), getFormattedCost());
    }
}
