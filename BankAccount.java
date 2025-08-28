// BankAccount.java
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private double balance;
    private String pin;
    private List<String> transactions;  // store history

    public BankAccount(double initialBalance, String pin) {
        this.balance = initialBalance;
        this.pin = pin;
        this.transactions = new ArrayList<>();
        transactions.add("Account created with balance: " + initialBalance);
    }

    public boolean checkPin(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public void changePin(String newPin) {
        this.pin = newPin;
        transactions.add("PIN changed successfully");
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: " + amount + " | Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add("Withdrew: " + amount + " | Balance: " + balance);
        } else {
            System.out.println("❌ Insufficient balance!");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void showTransactions() {
        System.out.println("\n📜 Transaction History:");
        for (String t : transactions) {
            System.out.println("- " + t);
        }
    }
}
