package part3;

import javax.swing.*;

import part1.Account;
import part1.Transaction;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class GUI extends JFrame {
    private static final long serialVersionUID = 1L;

    private Transaction transferObject = new Transaction();
    private LinkedList<Account> globalAccounts;
    private JLabel showAllData;
    private JButton showAllButton, depositButton, withdrawButton, transferButton;
    private JTextField accDeposit, depositInput, accWithdraw, withdrawInput;
    private JTextField acc1Transfer, acc2Transfer, transferAmount;

    public GUI(LinkedList<Account> accounts) {
        super("Simple Banking System");
        this.globalAccounts = accounts;

        getContentPane().setLayout(null);

        showAllButton = new JButton("Show All Accounts");
        showAllButton.setBackground(new Color(138, 193, 255));
        showAllButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        showAllButton.setBounds(276, 23, 200, 35);  
        getContentPane().add(showAllButton);

        showAllData = new JLabel();
        showAllData.setVerticalAlignment(SwingConstants.TOP);
        showAllData.setFont(new Font("Tahoma", Font.PLAIN, 15));
        showAllData.setOpaque(true);
        showAllData.setBackground(Color.WHITE);
        showAllData.setBounds(175, 70, 380, 100);
        getContentPane().add(showAllData);

        JLabel depositLabel = new JLabel("Deposit Section");
        depositLabel.setFont(new Font("Ubuntu", Font.PLAIN, 15));
        depositLabel.setForeground(new Color(47, 79, 79));
        depositLabel.setBounds(65, 210, 120, 25);
        getContentPane().add(depositLabel);

        JLabel accDepositLabel = new JLabel("Account Number:");
        accDepositLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        accDepositLabel.setForeground(new Color(55, 71, 79));
        accDepositLabel.setBounds(30, 246, 149, 25);
        getContentPane().add(accDepositLabel);

        accDeposit = new JTextField();
        accDeposit.setBounds(162, 247, 100, 25);
        getContentPane().add(accDeposit);

        JLabel depositAmountLabel = new JLabel("Amount:");
        depositAmountLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        depositAmountLabel.setForeground(new Color(55, 71, 79));
        depositAmountLabel.setBounds(30, 282, 74, 25);
        getContentPane().add(depositAmountLabel);

        depositInput = new JTextField();
        depositInput.setBounds(101, 282, 100, 25);
        getContentPane().add(depositInput);

        depositButton = new JButton("Deposit");
        depositButton.setBackground(new Color(76, 175, 80));
        depositButton.setBounds(65, 330, 100, 25);
        getContentPane().add(depositButton);

        JLabel withdrawLabel = new JLabel("Withdraw Section");
        withdrawLabel.setFont(new Font("Ubuntu", Font.PLAIN, 15));
        withdrawLabel.setForeground(new Color(47, 79, 79));
        withdrawLabel.setBounds(515, 210, 134, 25);
        getContentPane().add(withdrawLabel);

        JLabel accWithdrawLabel = new JLabel("Account Number:");
        accWithdrawLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        accWithdrawLabel.setForeground(new Color(55, 71, 79));
        accWithdrawLabel.setBounds(482, 246, 134, 25);
        getContentPane().add(accWithdrawLabel);

        accWithdraw = new JTextField();
        accWithdraw.setBounds(618, 247, 100, 25);
        getContentPane().add(accWithdraw);

        JLabel withdrawAmountLabel = new JLabel("Amount:");
        withdrawAmountLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        withdrawAmountLabel.setForeground(new Color(55, 71, 79));
        withdrawAmountLabel.setBounds(482, 282, 60, 25);
        getContentPane().add(withdrawAmountLabel);

        withdrawInput = new JTextField();
        withdrawInput.setBounds(560, 283, 100, 25);
        getContentPane().add(withdrawInput);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBackground(new Color(244, 67, 54));
        withdrawButton.setBounds(531, 330, 100, 25);
        getContentPane().add(withdrawButton);

        JLabel transferLabel = new JLabel("Transfer Section");
        transferLabel.setFont(new Font("Ubuntu", Font.PLAIN, 15));
        transferLabel.setForeground(new Color(47, 79, 79));
        transferLabel.setBounds(301, 373, 125, 25);
        getContentPane().add(transferLabel);

        JLabel fromLabel = new JLabel("From Acc#:");
        fromLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        fromLabel.setForeground(new Color(55, 71, 79));
        fromLabel.setBounds(143, 409, 84, 25);
        getContentPane().add(fromLabel);

        acc1Transfer = new JTextField();
        acc1Transfer.setBounds(237, 409, 100, 25);
        getContentPane().add(acc1Transfer);

        JLabel toLabel = new JLabel("To Acc#:");
        toLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        toLabel.setForeground(new Color(55, 71, 79));
        toLabel.setBounds(143, 440, 80, 25);
        getContentPane().add(toLabel);

        acc2Transfer = new JTextField();
        acc2Transfer.setBounds(237, 445, 100, 25);
        getContentPane().add(acc2Transfer);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        amountLabel.setForeground(new Color(55, 71, 79));
        amountLabel.setBounds(393, 409, 60, 25);
        getContentPane().add(amountLabel);

        transferAmount = new JTextField();
        transferAmount.setBounds(471, 409, 100, 25);
        getContentPane().add(transferAmount);

        transferButton = new JButton("Transfer");
        transferButton.setBackground(new Color(87, 175, 247));
        transferButton.setBounds(426, 445, 100, 25);
        getContentPane().add(transferButton);

        HandlerClass handler = new HandlerClass();
        showAllButton.addActionListener(handler);
        depositButton.addActionListener(handler);
        withdrawButton.addActionListener(handler);
        transferButton.addActionListener(handler);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class HandlerClass implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == showAllButton) {
                    updateAccountDisplay();	
                }
                else if (e.getSource() == depositButton) {
                    int accNum = Integer.parseInt(accDeposit.getText().trim());
                    int amount = Integer.parseInt(depositInput.getText().trim());
                    for (Account acc : globalAccounts) {
                        if (acc.getAccountNum() == accNum) {
                            acc.deposit(amount);
                            updateAccountDisplay();
                            JOptionPane.showMessageDialog(null, "Deposited " + amount + " to account " + accNum);
                            accDeposit.setText("");
                            depositInput.setText("");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Account not found.");
                }
                else if (e.getSource() == withdrawButton) {
                    int accNum = Integer.parseInt(accWithdraw.getText().trim());
                    int amount = Integer.parseInt(withdrawInput.getText().trim());
                    for (Account acc : globalAccounts) {
                        if (acc.getAccountNum() == accNum) {
                            if (amount > 0 && amount <= acc.getBalance()) {
                                acc.withdraw(amount);
                                updateAccountDisplay();
                                JOptionPane.showMessageDialog(null, "Withdrew " + amount + " from account " + accNum);
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid or insufficient amount.");
                            }
                            accWithdraw.setText("");
                            withdrawInput.setText("");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Account not found.");
                }
                else if (e.getSource() == transferButton) {
                    int from = Integer.parseInt(acc1Transfer.getText().trim());
                    int to = Integer.parseInt(acc2Transfer.getText().trim());
                    int amt = Integer.parseInt(transferAmount.getText().trim());
                    Account src = null, dst = null;
                    for (Account acc : globalAccounts) {
                        if (acc.getAccountNum() == from) src = acc;
                        if (acc.getAccountNum() == to)   dst = acc;
                    }
                    if (src != null && dst != null && amt > 0 && src.getBalance() >= amt) {
                        transferObject.transfer(src, dst, amt);
                        updateAccountDisplay();
                        JOptionPane.showMessageDialog(null,"Transferred " + amt + " from " + from + " to " + to);
                        acc1Transfer.setText("");
                        acc2Transfer.setText("");
                        transferAmount.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Transfer failed. Check accounts or balance.");
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }

        private void updateAccountDisplay() {
            StringBuilder sb = new StringBuilder();
            for (Account acc : globalAccounts) {
                sb.append("Name: ")
                  .append(acc.getFirstName()).append(" ").append(acc.getLastName())
                  .append(", Acc #: ").append(acc.getAccountNum())
                  .append(", Balance: ").append(acc.getBalance())
                  .append("\n");
            }
            showAllData.setText("<html>" + sb.toString().replace("\n", "<br>") + "</html>");
        }
    }
}