package id.raidnav.app.photogram.services;

import id.raidnav.app.photogram.data.models.Account;

import java.util.Optional;

public interface AccountService {

  Account create(Account account);

  Account update(String userName, Account account);

  Optional<Account> get(String userName);

  void delete(String userName);
}
