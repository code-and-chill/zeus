package id.raidnav.app.photogram.repositories.impl;

import id.raidnav.app.photogram.data.models.Account;
import id.raidnav.app.photogram.repositories.FolloweRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FolloweeRepositoryImpl implements FolloweRepository {

  @Autowired
  private MongoTemplate mongoTemplate;

  @Override
  public List<Account> getFollowing(String userName, int page, int perPage) {
    return null;
  }

  @Override
  public List<Account> getFollowers(String userName, int page, int perPage) {
    return null;
  }

  @Override
  public Long getTotalFollower(String userName) {
    return null;
  }

  @Override
  public Long getTotalFollowing(String userName) {
    return null;
  }
}
