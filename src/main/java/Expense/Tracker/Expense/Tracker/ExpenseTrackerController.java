package Expense.Tracker.Expense.Tracker;
import java.util.Scanner;

public class ExpenseTrackerController {
    public static void main(String[] args) {

        ExpenseTrackerService expenseTrackerService = new ExpenseTrackerService();


        System.out.println("==================================");
        System.out.println("      EXPENSE TRACKER SYSTEM      ");
        System.out.println("==================================");
        System.out.println("1. Add New Expense");
        System.out.println("2. Update Existing Expense");
        System.out.println("3. Delete Expense");
        System.out.println("4. View All Expenses");
        System.out.println("5. View Total Summary");
        System.out.println("6. View Monthly Summary (Current Year)");
        System.out.println("0. Exit");
        do {
        System.out.println("==================================");
        System.out.print("Select an option: ");

        Scanner s = new java.util.Scanner(System.in);

        int option = s.nextInt();

        switch (option) {
            case 1:
                System.out.println("Type the description of the expense:");
                String description = s.next();
                System.out.println("Type the amount of the expense:");
                int amount = s.nextInt();
                System.out.println(expenseTrackerService.addExpense(description, amount));
                break;
            case 2:
                System.out.println("Type the id of the expense:");
                int id = s.nextInt();
                System.out.println("Type the new description of the expense:");
                description = s.next();
                System.out.println("type the new amount of the expense:");
                amount = s.nextInt();
                System.out.println(expenseTrackerService.updateExpense(id,description, amount));
                break;
            case 3:
                System.out.println("Type the id of the expense:");
                 id = s.nextInt();
                System.out.println(expenseTrackerService.deleteExpense(id));
                break;
            case 4:
                System.out.println(expenseTrackerService.viewAllExpenses());
                break;
            case 5:
                System.out.println(expenseTrackerService.viewTotalSummary());
                break;
            case 6:
                System.out.println(expenseTrackerService.viewMonthlySummary());
                break;
            case 0:
                System.out.println("Exiting the system Goodbye!");
                s.close();
                return;
            default:
                System.out.println("Invalid option. Please select a valid option from the menu.");
        }
        }while (true);
    }

}
