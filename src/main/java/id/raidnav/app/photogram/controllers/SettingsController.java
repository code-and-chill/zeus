package id.raidnav.app.photogram.controllers;

import id.raidnav.app.photogram.controllers.spec.ChangePasswordSpec;
import id.raidnav.app.photogram.data.models.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.metrics.annotation.Timed;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Timed
@RestController
@RequestMapping("settings")
public class SettingsController {

  @PostMapping("/privacy/{username}")
  public ResponseEntity<Map<String, String>> setPrivacyConfig(@PathVariable("username") String username,
                                                              @RequestBody String body) {
    return null;
  }

  @PostMapping("/appearance/{username}")
  public ResponseEntity<Map<String, String>> setAppearance(@PathVariable("username") String username,
                                                           @RequestBody String body) {
    return null;
  }

  @PostMapping("/notifications/{username}")
  public ResponseEntity<Map<String, String>> setNotifications(@PathVariable("username") String username) {
    return null;
  }

  @PostMapping("/password/{username}")
  public ResponseEntity<Account> changePassword(@PathVariable("username") String username,
                                                @RequestBody @Validated ChangePasswordSpec spec) {
    // TODO: call auth service
    return null;
  }
}
