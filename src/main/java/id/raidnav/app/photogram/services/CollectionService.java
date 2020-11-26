package id.raidnav.app.photogram.services;

import id.raidnav.app.photogram.data.models.Collection;

import java.util.List;

public interface CollectionService {

  List<Collection> getAll(String username);

  Collection get(String id);

  Collection upsert(Collection collection);

  void delete(String id);
}
