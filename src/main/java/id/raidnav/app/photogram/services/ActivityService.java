package id.raidnav.app.photogram.services;

import id.raidnav.app.photogram.data.models.Activity;
import id.raidnav.app.photogram.data.models.Page;

public interface ActivityService {

  Page<Activity> getActivities(String username, int page, int perPage);
}
