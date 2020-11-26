package id.raidnav.app.photogram.repositories;

import id.raidnav.app.photogram.data.models.Story;
import id.raidnav.app.photogram.data.models.Highlight;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HighlightRepository {

  void create(Highlight highlight);

  Highlight addStory(String id, List<Story> stories);

  Highlight eraseStory(String id, List<Story> stories);

  List<Highlight> getAll(String userName, int perPage, int offset);
}
