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
    private IInfoProvider<Double, Integer> balanceProvider;

    public BankAccountController(IAccountOperator withdrawOperator,
        IAccountOperator depositOperator,
        IInfoProvider<List<Transaction>, Integer> transactionProvider,
        IInfoProvider<Double, Integer> balanceProvider) {
        this.withdrawOperator = withdrawOperator;
        this.depositOperator = depositOperator;
        this.transactionProvider = transactionProvider;
        this.balanceProvider = balanceProvider;
    }

    public boolean withdraw(int accountId, double amount) {
        if (getBalanceByAccountId(accountId) >= amount) {
            this.withdrawOperator.execute(accountId, amount);
            return true;
        }
        return false;
    }

    public void deposit(int accountId, double amount) {
        this.depositOperator.execute(accountId, amount);
    }

    public List<Transaction> getTransactionsByAccountId(Integer accountId) {
        return transactionProvider.get(accountId);
    }

    public double getBalanceByAccountId(Integer accountId) {
        return balanceProvider.get(accountId);
    }
}
