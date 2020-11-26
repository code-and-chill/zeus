package id.raidnav.app.photogram.services.impl;

import id.raidnav.app.photogram.data.models.Account;
import id.raidnav.app.photogram.data.models.Page;
import id.raidnav.app.photogram.repositories.FolloweRepository;
import id.raidnav.app.photogram.services.FolloweeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolloweeServiceImpl implements FolloweeService {

  @Autowired
  private FolloweRepository followeRepository;

  @Override
  public void followAccount(Account a, Account b) {
    // toggle follow: if already followed, then proceed the opposite
  }

  @Override
  public Page<Account> getFollowers(String userName, int page, int perPage) {
    List<Account> accounts = followeRepository.getFollowers(userName, page, perPage);
    Long numAccounts = followeRepository.getTotalFollower(userName);
    return new Page<>(accounts, numAccounts, page, perPage);
  }

  @Override
  public Page<Account> getFollowees(String userName, int page, int perPage) {
    List<Account> accounts = followeRepository.getFollowing(userName, page, perPage);
    Long numAccounts = followeRepository.getTotalFollowing(userName);
    return new Page<>(accounts, numAccounts, page, perPage);
  }
}
