package id.raidnav.app.photogram.services;

import id.raidnav.app.photogram.data.models.Story;
import id.raidnav.app.photogram.data.models.Highlight;
import id.raidnav.app.photogram.data.models.Page;

import java.util.List;

public interface HighlightService {

  Highlight create(Highlight highlight);

  Highlight addStory(String name, List<Story> stories);

  Highlight eraseStory(String name, List<Story> stories);

  void remove(String name, String username);

  Page<Highlight> getAll(String userName, int page, int perPage);
}
