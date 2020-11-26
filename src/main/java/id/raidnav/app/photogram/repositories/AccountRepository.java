package id.raidnav.app.photogram.repositories;

import id.raidnav.app.photogram.data.models.Account;

import java.util.Optional;

public interface AccountRepository {

  Optional<Account> findByUserName(String userName);

  Account upsert(Account account);

  void delete(Account account);
}
