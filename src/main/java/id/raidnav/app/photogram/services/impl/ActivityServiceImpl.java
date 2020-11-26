package id.raidnav.app.photogram.services.impl;

import id.raidnav.app.photogram.data.models.Activity;
import id.raidnav.app.photogram.data.models.Page;
import id.raidnav.app.photogram.services.ActivityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ActivityServiceImpl implements ActivityService {

  @Override
  public Page<Activity> getActivities(String username, int page, int perPage) {
    return new Page<>(new ArrayList<>(), 0L, page, perPage);
  }
}
