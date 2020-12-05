package id.raidnav.app.photogram.repositories.impl;

import id.raidnav.app.photogram.data.models.Highlight;
import id.raidnav.app.photogram.data.models.Story;
import id.raidnav.app.photogram.repositories.HighlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class HighlightRepositoryImpl implements HighlightRepository {

  @Autowired
  private MongoTemplate mongoTemplate;

  @Override
  public void create(Highlight highlight) {
    mongoTemplate.insert(highlight);
  }

  @Override
  public Highlight addStory(String id, List<Story> stories) {
    return null;
  }

  @Override
  public Highlight eraseStory(String id, List<Story> stories) {
    return null;
  }

  @Override
  public List<Highlight> getAll(String userName, int limit, int offset) {
    return null;
  }
}
