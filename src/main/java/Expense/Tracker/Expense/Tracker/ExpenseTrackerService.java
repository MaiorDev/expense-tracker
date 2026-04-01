package Expense.Tracker.Expense.Tracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExpenseTrackerService {

    private List<Expense> expenses = new ArrayList<>();
    private int idCount = 1;

    public String addExpense(String description, int amount) {
        if (description == null || description.isEmpty()) {
            return "Description cannot be empty.";
        }
        expenses.add(new Expense(idCount++, description, amount, LocalDate.now()));
        return "Expense added successfully.";
    }

    public String updateExpense(int id, String newDescription, int newAmount) {
        for (Expense e : expenses) {
            if (e.getId() == id) {
                e.setDescription(newDescription);
                e.setAmount(newAmount);
                return "Expense updated successfully.";
            }
        }
        return "Expense ID " + id + " not found.";
    }

    public String deleteExpense(int id) {
        boolean removed = expenses.removeIf(e -> e.getId() == id);
        return removed ? "Expense deleted successfully." : "Expense ID not found.";
    }

    public String viewAllExpenses() {
        if (expenses.isEmpty()) return "No expenses recorded.";
        StringBuilder sb = new StringBuilder();
        for (Expense e : expenses) {
            sb.append(e.getId()).append(". ").append(e.getDescription())
                    .append(": $").append(e.getAmount())
                    .append(" [").append(e.getDate()).append("]\n");
        }
        return sb.toString();
    }

    public String viewTotalSummary() {
        int total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return "Total Expenses: $" + total;
    }

    public String viewMonthlySummary() {
        int total = 0;
        LocalDate now = LocalDate.now();
        for (Expense e : expenses) {
            if (e.getDate().getMonth() == now.getMonth() && e.getDate().getYear() == now.getYear()) {
                total += e.getAmount();
            }
        }
        return "Summary for " + now.getMonth() + " " + now.getYear() + ": $" + total;
    }

    static class Expense {
        private int id;
        private String description;
        private int amount;
        private LocalDate date;

        public Expense(int id, String description, int amount, LocalDate date) {
            this.id = id;
            this.description = description;
            this.amount = amount;
            this.date = date;
        }

        public int getId() { return id; }
        public String getDescription() { return description; }
        public void setDescription(String d) { this.description = d; }
        public int getAmount() { return amount; }
        public void setAmount(int a) { this.amount = a; }
        public LocalDate getDate() { return date; }
    }
}