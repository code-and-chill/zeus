package id.raidnav.app.photogram.repositories.impl;

import id.raidnav.app.photogram.data.models.Account;
import id.raidnav.app.photogram.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public class AccountRepositoryImpl implements AccountRepository {

  @Autowired
  private MongoTemplate mongoTemplate;

  @Override
  public Optional<Account> findByUserName(String userName) {
    Account account = mongoTemplate.findOne(new Query(Criteria.where("username").is(userName)), Account.class);
    return account == null ? Optional.empty() : Optional.of(account);
  }

  @Override
  public Account upsert(Account account) {
    return mongoTemplate.insert(account);
  }

  @Override
  public void delete(Account account) {
    mongoTemplate.remove(account);
  }
}
