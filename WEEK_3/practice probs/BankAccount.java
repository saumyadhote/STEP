public class BankAccount {
    // Static (Class) members
    static String bankName;
    static int totalAccounts;
    static double interestRate;

    // Instance members
    String accountNumber;
    String accountHolder;
    double balance;

    // Constructor
    BankAccount(String accNo, String holder, double bal) {
        this.accountNumber = accNo;
        this.accountHolder = holder;
        this.balance = bal;
        totalAccounts++;
    }

    // Static methods
    static void setBankName(String name) { bankName = name; }
    static void setInterestRate(double rate) { interestRate = rate; }
    static int getTotalAccounts() { return totalAccounts; }
    static void displayBankInfo() {
        System.out.println("Bank: " + bankName + ", Accounts: " + totalAccounts);
    }

    // Instance methods
    void deposit(double amt) { balance += amt; }
    void withdraw(double amt) { balance -= amt; }
    void calculateInterest() { balance += balance * interestRate; }
    void displayAccountInfo() {
        System.out.println(accountHolder + " | " + accountNumber +
                           " | Balance: " + balance);
    }

    public static void main(String[] args) {
        // Set static values
        BankAccount.setBankName("OpenAI Bank");
        BankAccount.setInterestRate(0.05);

        // Create accounts (instance members differ)
        BankAccount a1 = new BankAccount("101", "Alice", 1000);
        BankAccount a2 = new BankAccount("102", "Bob", 2000);

        // Show static members
        BankAccount.displayBankInfo();

        // Show instance members
        a1.deposit(500);
        a2.withdraw(300);

        a1.calculateInterest();
        a2.calculateInterest();

        a1.displayAccountInfo();
        a2.displayAccountInfo();

        // Show total accounts using static method
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
    }
}
