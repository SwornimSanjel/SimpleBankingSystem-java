package part2;

import java.util.LinkedList;

import part1.Account;
import part1.Transaction;

public class MainPart2 {
    public static void main(String[] args) {
        try {
            // 1 = create ReadAccounts object using csv
            ReadAccounts reader = new ReadAccounts("Accounts.csv");

            // 2 to 5 = get LinkedLists 
            LinkedList<String> firstNames = reader.getFirstNames();
            LinkedList<String> lastNames = reader.getLastNames();
            LinkedList<Integer> accountList = reader.getAccounts();
            LinkedList<Integer> balanceList = reader.getBalances();

            // 6 = create LinkedList (creates account from constructor Account)
            LinkedList<Account> accounts = new LinkedList<>();
            for (int i = 0; i < firstNames.size(); i++) {
                accounts.add(new Account(firstNames.get(i), lastNames.get(i), accountList.get(i), balanceList.get(i)));
            }

            // 7 = print initial balances
            System.out.println("Initial Balances:");
            for (Account acc : accounts) {
                System.out.println("Account #" + acc.getAccountNum() + ": " + acc.getBalance());
            }

            // 8 = deposit 250 to 1st account
            accounts.get(0).deposit(250);
            System.out.println("Updated balance for Account #" + accounts.get(0).getAccountNum() + " following deposit: " + accounts.get(0).getBalance());

            // 9 = withdraw 500 from 2nd account
            accounts.get(1).withdraw(500);
            System.out.println("Updated balance for Account #" + accounts.get(1).getAccountNum() + " following withdrawal: " + accounts.get(1).getBalance());

            // 10 = transfer 250 from 1st to 2nd account
            Transaction t = new Transaction();
            t.transfer(accounts.get(0), accounts.get(1), 250);
            System.out.println("Updated balance for Account #" + accounts.get(0).getAccountNum() + " following transfer: " + accounts.get(0).getBalance());
            System.out.println("Updated balance for Account #" + accounts.get(1).getAccountNum() + " following transfer: " + accounts.get(1).getBalance());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
