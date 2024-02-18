import java.util.Scanner;
class BankAccount1 {
    private double balance;

    public BankAccount1(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds");
            return false;
        }
    }
}
class ATM1 {
    private BankAccount1 userAccount;

    public ATM1(BankAccount1 userAccount) {
        this.userAccount = userAccount;
    }

    public void displayMenu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                if (withdrawAmount > 0) {
                    if (userAccount.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
                    }
                } else {
                    System.out.println("Invalid amount");
                }
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                if (depositAmount > 0) {
                    userAccount.deposit(depositAmount);
                    System.out.println("Deposit successful. Updated balance: " + userAccount.getBalance());
                } else {
                    System.out.println("Invalid amount");
                }
                break;
            case 3:
                System.out.println("Current balance: " + userAccount.getBalance());
                break;
            case 4:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}


public class Main1 {
    public static void main(String[] args) {
        BankAccount1 userAccount = new BankAccount1(1000.0);
        ATM1 atm = new ATM1(userAccount);
        while (true) {
            atm.displayMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Select an option (1-4): ");
            int option = scanner.nextInt();
            atm.processOption(option);
        }
    }
}
