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
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be greater than 0.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: " + amount);
        } else if (amount > balance) {
            System.out.println("Withdrawal failed! Insufficient balance.");
        } else {
            System.out.println("Withdrawal amount must be greater than 0.");
        }
    }
}

class ATM {
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void start() {
        int option;
        do {
            System.out.println("-----------------------------");
            System.out.println("********* ATM INTERFACE *********");
            System.out.println("1 : Withdraw");
            System.out.println("2 : Deposit");
            System.out.println("3 : Check Balance");
            System.out.println("4 : Exit");
            System.out.println("-----------------------------");
            System.out.print("Enter the option to continue: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Successfully exited. Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Enter a valid option.");
            }
        } while (option != 4);
    }

    private void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = sc.nextDouble();
        account.withdraw(amount);
    }

    private void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = sc.nextDouble();
        account.deposit(amount);
    }

    private void checkBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(0);
        ATM atm = new ATM(account);
        atm.start();
    }
}
