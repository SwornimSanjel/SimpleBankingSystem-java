package part1; 

public class Account extends Customer {
    private int balance;
    private int accountNumber;

    public Account(String FName, String LName, int accNum, int accBal) {
        setFirstName(FName);
        setLastName(LName);
        this.accountNumber = accNum;
        this.balance = accBal;
    }

    public int getBalance() {
        return balance;
    }

    public int getAccountNum() {
        return accountNumber;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit failed: Amount must be greater than zero.");
        }
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal failed: Amount must be greater than zero.");
        } else if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Withdrawal failed: Not enough balance in the account.");
        }
    }
}