// Main.java
public class Main {
    public static void main(String[] args) {
        // Create account with ₹5000 balance and PIN "1234"
        BankAccount account = new BankAccount(5000, "1234");
        Atm atm = new Atm(account);
        atm.start();   // Run the ATM
    }
}
