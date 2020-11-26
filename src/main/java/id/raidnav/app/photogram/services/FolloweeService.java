package id.raidnav.app.photogram.services;

import id.raidnav.app.photogram.data.models.Account;
import id.raidnav.app.photogram.data.models.Page;

public interface FolloweeService {

  void followAccount(Account a, Account b);

  Page<Account> getFollowers(String userName, int page, int perPage);

  Page<Account> getFollowees(String userName, int page, int perPage);
}
