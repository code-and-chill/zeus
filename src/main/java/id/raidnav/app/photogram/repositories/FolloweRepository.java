package id.raidnav.app.photogram.repositories;

import id.raidnav.app.photogram.data.models.Account;

import java.util.List;

public interface FolloweRepository {

  List<Account> getFollowing(String userName, int page, int perPage);

  List<Account> getFollowers(String userName, int page, int perPage);

  Long getTotalFollower(String userName);

  Long getTotalFollowing(String userName);
}
