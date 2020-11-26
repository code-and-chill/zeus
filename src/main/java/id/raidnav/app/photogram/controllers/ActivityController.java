package id.raidnav.app.photogram.controllers;

import id.raidnav.app.photogram.data.models.Activity;
import id.raidnav.app.photogram.data.models.Page;
import id.raidnav.app.photogram.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.metrics.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Timed
@RestController
@RequestMapping(value = "activities")
public class ActivityController {

  @Autowired
  private ActivityService activityService;

  @GetMapping(value = "/{username}?page={page}&per_page={per_page}")
  public ResponseEntity<Page<Activity>> getActivities(@PathVariable("username") String username,
                                                      @PathVariable("page") int page,
                                                      @PathVariable("per_page") int perPage) {
    Page<Activity> activities = activityService.getActivities(username, page, perPage);
    return activities.getTotal() > 0 ? ResponseEntity.ok(activities) : ResponseEntity.notFound().build();
  }
}
