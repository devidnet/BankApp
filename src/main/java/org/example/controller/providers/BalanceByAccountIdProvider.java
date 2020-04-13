package org.example.controller.providers;

    import org.example.controller.interfaces.IInfoProvider;
    import org.example.model.interfaces.IDataSaver;

public class BalanceByAccountIdProvider implements
    IInfoProvider<Double, Integer> {

  private IDataSaver dataSaver;

  public BalanceByAccountIdProvider(IDataSaver dataSaver) {
    this.dataSaver = dataSaver;
  }

  @Override
  public Double get(Integer accountId) {
    return dataSaver.getBalanceByAccountId(accountId);
  }
}
