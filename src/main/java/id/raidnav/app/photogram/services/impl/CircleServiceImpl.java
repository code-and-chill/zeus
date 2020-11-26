package id.raidnav.app.photogram.services.impl;

import id.raidnav.app.photogram.data.models.Account;
import id.raidnav.app.photogram.data.models.Circle;
import id.raidnav.app.photogram.repositories.CircleRepository;
import id.raidnav.app.photogram.services.CircleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CircleServiceImpl implements CircleService {

  private final CircleRepository circleRepository;

  public CircleServiceImpl(CircleRepository circleRepository) {
    this.circleRepository = circleRepository;
  }

  @Override
  public Circle addCircle(String userName, String circleName) {
    return circleRepository.save(Circle.builder().name(circleName).username(userName).build());
  }

  @Override
  public Optional<Circle> get(String name) {
    return circleRepository.findById(name);
  }

  @Override
  public List<Circle> getAll(String userName) {
    return circleRepository.findAll(userName);
  }

  @Override
  public Circle modifyCircleName(String userName, String currentName, String proposedName) {

    return null;
  }

  @Override
  public Circle updateMembers(String username, String name, List<Account> account) {
    return null;
  }

  @Override
  public void delete(String username, String name) {

  }

}
