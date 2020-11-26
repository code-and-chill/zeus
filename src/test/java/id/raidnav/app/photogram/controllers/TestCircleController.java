package id.raidnav.app.photogram.controllers;

import id.raidnav.app.photogram.services.CircleService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class TestCircleController {

  @InjectMocks
  private CircleController controller;

  @Mock
  private CircleService service;

  @BeforeMethod
  public void initMocks() {
    MockitoAnnotations.initMocks(this);
  }


}
