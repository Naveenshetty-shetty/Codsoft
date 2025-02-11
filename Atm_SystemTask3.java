import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }
        balance += amount;
        System.out.println("Successfully deposited Rs." + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }
        balance -= amount;
        System.out.println("Successfully withdrawn Rs." + amount);
    }
}

class ATM {
    private final BankAccount account;
    private final Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;

        do {
            printMenu();
            choice = getUserChoice();
            handleUserChoice(choice);
        } while (choice != 4);

        scanner.close();
    }

    private void printMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private int getUserChoice() {
        return scanner.nextInt();
    }

    private void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                processWithdrawal();
                break;
            case 2:
                processDeposit();
                break;
            case 3:
                System.out.println("Current balance: Rs." + account.getBalance());
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void processWithdrawal() {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    private void processDeposit() {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }
}


public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(10000); // Initial balance Rs. 10,000
        ATM atm = new ATM(userAccount);
        atm.displayMenu();
    }
}
