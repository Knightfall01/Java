package com.amrita.jpl.cys21076.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Abstract class for bank accounts
abstract class BankAccount {
    private String accountNumber;
    private String accountHolder;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);
}

// Interface for bank transactions
interface BankTransaction {
    void execute();
}

// Class for deposit transaction
class DepositTransaction implements BankTransaction {
    private BankAccount account;
    private double amount;

    public DepositTransaction(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.deposit(amount);
    }
}

// Class for withdraw transaction
class WithdrawTransaction implements BankTransaction {
    private BankAccount account;
    private double amount;

    public WithdrawTransaction(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.withdraw(amount);
    }
}

// Class for creating a new account
class AccountCreator {
    public static BankAccount createAccount(String accountNumber, String accountHolder) {
        // Implement account creation logic
        return null;
    }
}

// Class representing the ATM GUI
class ATMFrame extends JFrame {
    private JLabel accountNumberLabel;
    private JLabel accountHolderLabel;
    private JTextField accountNumberField;
    private JTextField accountHolderField;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton transferButton;

    public ATMFrame() {
        setTitle("ATM Banking System");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        accountNumberLabel = new JLabel("Account Number:");
        add(accountNumberLabel);

        accountNumberField = new JTextField();
        add(accountNumberField);

        accountHolderLabel = new JLabel("Account Holder:");
        add(accountHolderLabel);

        accountHolderField = new JTextField();
        add(accountHolderField);

        depositButton = new JButton("Deposit");
        add(depositButton);

        withdrawButton = new JButton("Withdraw");
        add(withdrawButton);

        transferButton = new JButton("Transfer");
        add(transferButton);

        // Add event listeners to the buttons
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountNumber = accountNumberField.getText();
                String accountHolder = accountHolderField.getText();

                // Create a new deposit transaction
                BankAccount account = AccountCreator.createAccount(accountNumber, accountHolder);
                double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter amount to deposit:"));
                BankTransaction transaction = new DepositTransaction(account, amount);
                transaction.execute();

                JOptionPane.showMessageDialog(null, "Deposit successful.");
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountNumber = accountNumberField.getText();
                String accountHolder = accountHolderField.getText();

                // Create a new withdraw transaction
                BankAccount account = AccountCreator.createAccount(accountNumber, accountHolder);
                double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter amount to withdraw:"));
                BankTransaction transaction = new WithdrawTransaction(account, amount);
                transaction.execute();

                JOptionPane.showMessageDialog(null, "Withdrawal successful.");
            }
        });

        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement transfer logic
            }
        });
    }
}

// Main class to start the application
public class ATMApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ATMFrame().setVisible(true);
            }
        });
    }
}
