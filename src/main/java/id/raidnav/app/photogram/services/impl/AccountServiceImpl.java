package id.raidnav.app.photogram.services.impl;

import id.raidnav.app.photogram.data.models.Account;
import id.raidnav.app.photogram.repositories.AccountRepository;
import id.raidnav.app.photogram.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

  @Autowired
  private AccountRepository accountRepository;

  @Override
  public Optional<Account> get(String userName) {
    return accountRepository.findByUserName(userName);
  }

  @Override
  public void delete(String userName) {
    accountRepository
        .findByUserName(userName)
        .ifPresent(accountRepository::delete);
  }

  @Override
  public Account update(String userName, Account account) {
    return accountRepository.upsert(account);
  }

  @Override
  public Account create(Account account) {
    return accountRepository.upsert(account);
  }
}
