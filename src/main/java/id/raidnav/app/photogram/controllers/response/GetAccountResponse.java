package id.raidnav.app.photogram.controllers.response;

import id.raidnav.app.photogram.data.models.Account;

public class GetAccountResponse {

  private final Account account;
  private final Long numFollowers;
  private final Long numFollowees;

  public GetAccountResponse() {
    this(null, 0L, 0L);
  }

  public GetAccountResponse(Account account, Long numFollowers, Long numFollowees) {
    this.account = account;
    this.numFollowers = numFollowers;
    this.numFollowees = numFollowees;
  }

  public Account getAccount() {
    return account;
  }

  public Long getNumFollowers() {
    return numFollowers;
  }

  public Long getNumFollowees() {
    return numFollowees;
  }
}
