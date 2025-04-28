import java.util.Scanner;

public class ATM {
    private double balance;
    private String pinCode;
    public ATM(String pinCode) {
        this.balance = 1000.0;
        this.pinCode = pinCode;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Amount must be positive.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else if (amount <= 0) {
            System.out.println("Amount must be positive.");
        } else {
            System.out.println("Insufficient balance!");
        }
    }
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }


    public boolean checkPin(String inputPin) {
        return pinCode.equals(inputPin);
    }


    public void showMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        ATM atm = new ATM("1234");
        System.out.print("Enter PIN: ");
        String inputPin = sc.next();
        if (!atm.checkPin(inputPin)) {
            System.out.println("Invalid PIN. Access denied.");
            return;
        }

        System.out.println("PIN validated successfully. Welcome!");
        while (true) {
            atm.showMenu();
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting ATM... Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
