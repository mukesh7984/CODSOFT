import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private double balance;
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive number.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Balance: $" + balance;
    }
}
public class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;
    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }
    public void showMenu() {
        while (true) {
            System.out.println("\nATM Interface");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
                    break;
            }
        }
    }
    public void checkBalance() {
        System.out.println("Current Balance: $" + bankAccount.getBalance());
    }
    public void deposit() {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        bankAccount.deposit(amount);
    }
    public void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        bankAccount.withdraw(amount);
    }
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789", 500.0); // Example account with initial balance
        ATM atm = new ATM(account);
        atm.showMenu();
    }
}

