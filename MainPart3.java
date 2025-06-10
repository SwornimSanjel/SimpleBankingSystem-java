package part3;

import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import part1.Account;
import part2.ReadAccounts;

public class MainPart3 {
    public static void main(String[] args) {
        try {
        	
            // 1 = create ReadAccounts object with csv file path
            ReadAccounts reader = new ReadAccounts("Accounts.csv");

            // 2 to 5 = get LinkedLists from file
            LinkedList<String> firstNames = reader.getFirstNames();
            LinkedList<String> lastNames = reader.getLastNames();
            LinkedList<Integer> accountList = reader.getAccounts();  
            LinkedList<Integer> balanceList = reader.getBalances(); 

            // 6 = create LinkedList of Account objects
            LinkedList<Account> accounts = new LinkedList<>();
            for (int i = 0; i < firstNames.size(); i++) {
                accounts.add(new Account(firstNames.get(i), lastNames.get(i), accountList.get(i), balanceList.get(i)));
            }

            // 7 = pass accounts to GUI
            GUI gui = new GUI(accounts);
            gui.setSize(1000, 1000);                               
            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            gui.setVisible(true);                              

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading accounts: " + e.getMessage());
        }
    }
}