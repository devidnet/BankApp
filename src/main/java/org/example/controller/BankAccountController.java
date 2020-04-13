package org.example.controller;

import java.util.List;
import org.example.controller.interfaces.IAccountOperator;
import org.example.controller.interfaces.IInfoProvider;
import org.example.model.Account;
import org.example.model.Transaction;

public class BankAccountController {
    private IAccountOperator withdrawOperator;
    private IAccountOperator depositOperator;
    private IInfoProvider<List<Transaction>, Integer> transactionProvider;

    public BankAccountController(IAccountOperator withdrawOperator,
        IAccountOperator depositOperator,
        IInfoProvider<List<Transaction>, Integer> transactionProvider) {
        this.withdrawOperator = withdrawOperator;
        this.depositOperator = depositOperator;
        this.transactionProvider = transactionProvider;
    }

    public void withdraw(int accountId, double amount) {
        this.withdrawOperator.execute(accountId, amount);
    }

    public void deposit(int accountId, double amount) {
        this.depositOperator.execute(accountId, amount);
    }

    public List<Transaction> getTransactionsByAccountId(Integer accountId) {
        return transactionProvider.get(accountId);
    }
}
