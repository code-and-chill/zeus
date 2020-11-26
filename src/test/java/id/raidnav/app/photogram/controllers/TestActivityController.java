package id.raidnav.app.photogram.controllers;

import id.raidnav.app.photogram.data.models.Activity;
import id.raidnav.app.photogram.data.models.Page;
import id.raidnav.app.photogram.services.ActivityService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

@Test(groups = "small")
public class TestActivityController {

  @InjectMocks
  private ActivityController activityController;

  @Mock
  private ActivityService activityService;

  @BeforeMethod
  public void initMocks() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testGetActivity() {
    Mockito.doReturn(new Page<Activity>(new ArrayList<>(), 0L, 1, 10)).when(activityService).getActivities("", 1, 10);
    ResponseEntity<Page<Activity>> responseActivities = activityController.getActivities("", 1, 10);

    Assert.assertEquals(responseActivities.getStatusCode(), HttpStatus.OK);
    Assert.assertEquals(responseActivities.getBody().getData(), new ArrayList<>());
    Assert.assertEquals(responseActivities.getBody().getTotal(), Long.valueOf(0));
    Assert.assertEquals(responseActivities.getBody().getCurrentPage(), 1);
    Assert.assertEquals(responseActivities.getBody().getPerPage(), 10);
  }
}
