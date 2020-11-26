package id.raidnav.app.photogram.services.impl;

import id.raidnav.app.photogram.data.models.Collection;
import id.raidnav.app.photogram.services.CollectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {
  @Override
  public List<Collection> getAll(String username) {
    return null;
  }

  @Override
  public Collection get(String id) {
    return null;
  }

  @Override
  public Collection upsert(Collection collection) {
    return null;
  }

  @Override
  public void delete(String id) {

  }
}
