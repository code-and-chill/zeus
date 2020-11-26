package id.raidnav.app.photogram.services.impl;

import id.raidnav.app.photogram.data.models.Story;
import id.raidnav.app.photogram.data.models.Highlight;
import id.raidnav.app.photogram.data.models.Page;
import id.raidnav.app.photogram.repositories.HighlightRepository;
import id.raidnav.app.photogram.services.HighlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighlightServiceImpl implements HighlightService {

  @Autowired
  private HighlightRepository highlightRepository;

  @Override
  public Highlight create(Highlight highlight) {
    return null;
  }

  @Override
  public Highlight addStory(String name, List<Story> story) {
    return null;
  }

  @Override
  public Highlight eraseStory(String name, List<Story> story) {
    return null;
  }

  @Override
  public void remove(String name, String username) {

  }

  @Override
  public Page<Highlight> getAll(String userName, int page, int perPage) {
    return null;
  }
}
