package part1;

public class MainPart1 {
    public static void main(String[] args) {
    	
        //1 = create account1
        Account account1 = new Account("Jeffrey", "Ting", 1, 2000);

        // 2 = create account2
        Account account2 = new Account("Hiran", "Patel", 2, 1000);

        // 3,4 = print balances
        System.out.println("The Initial Balance of Account 1 is: " + account1.getBalance());
        System.out.println("The Initial Balance of Account 2 is: " + account2.getBalance());

        // 5 = deposit 250 into account1
        account1.deposit(250);

        // 6 = print updated balance of acc1 = 2250
        System.out.println("After depositing 250 into Account 1: " + account1.getBalance());

        // 7 = withdraw 500 from account2
        account2.withdraw(500);

        // 8 = print updated balance of acc2 = 500
        System.out.println("After withdrawing 500 from Account 2: " + account2.getBalance());

        // 9 = creating an object called t from the Transaction class 
        Transaction t = new Transaction();

        // 10 = transfer 250 from acc1 - acc2
        t.transfer(account1, account2, 250);

        // 11, 12 = print final balances of acc1 and acc2
        System.out.println("After transferring 250 from Account 1 to Account 2:");
        System.out.println("Final Balance of Account 1 is: " + account1.getBalance());
        System.out.println("Final Balance of Account 2 is: " + account2.getBalance());
    }
}