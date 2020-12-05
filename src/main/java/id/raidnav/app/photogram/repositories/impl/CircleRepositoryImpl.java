package id.raidnav.app.photogram.repositories.impl;

import id.raidnav.app.photogram.data.models.Circle;
import id.raidnav.app.photogram.repositories.CircleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class CircleRepositoryImpl implements CircleRepository {

  @Autowired
  private MongoTemplate mongoTemplate;

  @Override
  public Circle save(Circle circle) {
    return mongoTemplate.insert(circle);
  }

  @Override
  public Optional<Circle> findById(String circleId) {
    Circle circle = mongoTemplate.findOne(new Query(Criteria.where("name").is(circleId)), Circle.class);
    return circle == null ? Optional.empty() : Optional.of(circle);
  }

  @Override
  public List<Circle> findAll(String uid) {
    return mongoTemplate.find(new Query(Criteria.where("username").is(uid)), Circle.class);
  }

  @Override
  public void delete(Circle circle) {
    mongoTemplate.remove(circle);
  }
}
