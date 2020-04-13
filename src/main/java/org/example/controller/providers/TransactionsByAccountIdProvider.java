package org.example.controller.providers;

    import java.util.List;
    import org.example.controller.interfaces.IInfoProvider;
    import org.example.model.Transaction;
    import org.example.model.interfaces.IDataSaver;


public class TransactionsByAccountIdProvider implements
    IInfoProvider<List<Transaction>, Integer> {

  private IDataSaver dataSaver;

  public TransactionsByAccountIdProvider(IDataSaver dataSaver) {
    this.dataSaver = dataSaver;
  }

  @Override
  public List<Transaction> get(Integer accountId) {
    return dataSaver.getTransactionsByAccountId(accountId);
  }
}