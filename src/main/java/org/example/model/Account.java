package org.example.model;

import static org.example.model.TransactionType.DEPOSIT;
import static org.example.model.TransactionType.WITHDRAW;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int id;
    private String ownerId;
    private double balance;
    private List<Transaction> transactions;

    public Account(int id, String ownerId) {
        this.id = id;
        this.ownerId = ownerId;
        transactions = new ArrayList<>();
        this.balance = 0;
    }

    public int getId() {
        return id;
    }
    public double getBalance() {
        return balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        if (transaction.getType() == WITHDRAW) {
            balance -= transaction.getAmount();
        } else if (transaction.getType() == DEPOSIT) {
            balance += transaction.getAmount();
        }
    }

    public String getOwnerId() {
        return ownerId;
    }
}
