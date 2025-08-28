// ATM.java
import java.util.Scanner;

public class Atm {
    private BankAccount account;
    private Scanner sc = new Scanner(System.in);

    public Atm(BankAccount account) {
        this.account = account;
    }

    public void start() {
        System.out.print("Enter PIN: ");
        String inputPin = sc.nextLine();

        if (!account.checkPin(inputPin)) {
            System.out.println("❌ Incorrect PIN. Exiting...");
            return;
        }

        System.out.println("✅ Login successful!");

        while (true) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Change PIN");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {
                case 1 -> System.out.println("💰 Balance: " + account.getBalance());
                case 2 -> {
                    System.out.print("Enter deposit: ");
                    account.deposit(sc.nextDouble());
                }
                case 3 -> {
                    System.out.print("Enter withdraw: ");
                    account.withdraw(sc.nextDouble());
                }
                case 4 -> account.showTransactions();
                case 5 -> {
                    System.out.print("Enter new PIN: ");
                    String newPin = sc.nextLine();
                    account.changePin(newPin);
                }
                case 6 -> {
                    System.out.println("👋 Thank you! Bye.");
                    return;
                }
                default -> System.out.println("❌ Invalid option!");
            }
        }
    }
}
