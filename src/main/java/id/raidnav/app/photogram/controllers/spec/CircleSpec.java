package id.raidnav.app.photogram.controllers.spec;

import id.raidnav.app.photogram.data.models.Account;

import java.util.List;

public class CircleSpec {

  private final String userName;
  private final String circleName;
  private final List<Account> friends;

  public CircleSpec(String userName, String circleName, List<Account> friends) {
    this.userName = userName;
    this.circleName = circleName;
    this.friends = friends;
  }

  public String getUserName() {
    return userName;
  }

  public String getCircleName() {
    return circleName;
  }

  public List<Account> getFriends() {
    return friends;
  }
}
