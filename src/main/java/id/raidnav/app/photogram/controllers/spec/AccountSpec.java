package id.raidnav.app.photogram.controllers.spec;

import id.raidnav.app.photogram.data.models.Account;

public class AccountSpec {

  private final Account account;

  public AccountSpec(Account account) {
    this.account = account;
  }

  public Account getAccount() {
    return account;
  }
}
