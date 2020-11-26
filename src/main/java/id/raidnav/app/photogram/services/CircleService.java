package id.raidnav.app.photogram.services;

import id.raidnav.app.photogram.data.models.Account;
import id.raidnav.app.photogram.data.models.Circle;

import java.util.List;
import java.util.Optional;

public interface CircleService {

  Circle addCircle(String userName, String name);

  Optional<Circle> get(String name);

  List<Circle> getAll(String username);

  Circle modifyCircleName(String username, String currentName, String proposedName);

  Circle updateMembers(String username, String name, List<Account> account);

  void delete(String username, String name);
}
