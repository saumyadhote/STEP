class PersonalAccount {
    // Instance variables
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;

    // Static variables
    private static int totalAccounts = 0;
    private static String bankName = "Default Bank";

    // Constructor
    public PersonalAccount(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = 0.0;
        this.totalIncome = 0.0;
        this.totalExpenses = 0.0;
        totalAccounts++;
    }

    // Static methods
    public static void setBankName(String name) {
        bankName = name;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    private static String generateAccountNumber() {
        return "ACCT" + (1000 + totalAccounts + 1);
    }

    // Instance methods
    public void addIncome(double amount, String description) {
        if (amount > 0) {
            currentBalance += amount;
            totalIncome += amount;
            System.out.println(description + ": Income added = " + amount);
        }
    }

    public void addExpense(double amount, String description) {
        if (amount > 0 && amount <= currentBalance) {
            currentBalance -= amount;
            totalExpenses += amount;
            System.out.println(description + ": Expense added = " + amount);
        } else {
            System.out.println("Insufficient balance for expense: " + description);
        }
    }

    public double calculateSavings() {
        return totalIncome - totalExpenses;
    }

    public void displayAccountSummary() {
        System.out.println("\n--- Account Summary ---");
        System.out.println("Bank: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expenses: " + totalExpenses);
        System.out.println("Current Balance: " + currentBalance);
        System.out.println("Savings: " + calculateSavings());
    }
}

public class PersonalFinanceManager {
    public static void main(String[] args) {
        // Set bank name (shared by all accounts)
        PersonalAccount.setBankName("Global Trust Bank");

        // Create accounts
        PersonalAccount acc1 = new PersonalAccount("Alice");
        PersonalAccount acc2 = new PersonalAccount("Bob");
        PersonalAccount acc3 = new PersonalAccount("Charlie");

        // Perform transactions
        acc1.addIncome(5000, "Salary");
        acc1.addExpense(1500, "Rent");

        acc2.addIncome(7000, "Freelance");
        acc2.addExpense(2000, "Groceries");

        acc3.addIncome(10000, "Business Profit");
        acc3.addExpense(3000, "Travel");

        // Display summaries
        acc1.displayAccountSummary();
        acc2.displayAccountSummary();
        acc3.displayAccountSummary();

        System.out.println("\nTotal Accounts Created: " + PersonalAccount.getTotalAccounts());
    }
}
