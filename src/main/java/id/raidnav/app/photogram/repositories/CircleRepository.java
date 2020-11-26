package id.raidnav.app.photogram.repositories;

import id.raidnav.app.photogram.data.models.Circle;
import id.raidnav.app.photogram.data.models.Story;

import java.util.List;
import java.util.Optional;

public interface CircleRepository {

  Circle save(Circle circle);

  Optional<Circle> findById(String circleId);

  List<Circle> findAll(String userName);

  void delete(Circle circle);

}
