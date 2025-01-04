import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    // Constructor to initialize account balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! Your new balance is: ₹" + balance);
        } else {
            System.out.println("Invalid amount! Please enter a positive value.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal successful! Your new balance is: ₹" + balance);
            } else {
                System.out.println("Insufficient balance! Your current balance is: ₹" + balance);
            }
        } else {
            System.out.println("Invalid amount! Please enter a positive value.");
        }
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount account;

    // Constructor to link the ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to display the ATM menu
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM! Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    // Method to check the balance
    public void checkBalance() {
        System.out.println("Your current balance is: ₹" + account.getBalance());
    }

    // Method to deposit money
    public void deposit(double amount) {
        account.deposit(amount);
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        account.withdraw(amount);
    }
}

// Main class to run the program
public class ATMMachine {
    public static void main(String[] args) {
        // Create a BankAccount object with an initial balance
        BankAccount account = new BankAccount(5000); // Initial balance: ₹5000

        // Create an ATM object linked to the BankAccount
        ATM atm = new ATM(account);

        // Show the ATM menu
        atm.showMenu();
    }
}
