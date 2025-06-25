
// Represents a user with an ID and account balance

public class User {
    private int userId;
    private int balance;

    // Constructor

    public User(int userId, int balance) {
        this.userId = userId;
        this.balance = balance;
    }

    // Getter for user ID

    public int getUserId() {
        return userId;
    }

    // Getter for balance

    public int getBalance() {
        return balance;
    }

    // Setter for balance (used when updating after booking)

    public void setBalance(int balance) {
        this.balance = balance;
    }
}