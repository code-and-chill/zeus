package id.raidnav.app.photogram.controllers;

import id.raidnav.app.photogram.controllers.spec.ChangePasswordSpec;
import id.raidnav.app.photogram.data.models.Account;
import id.raidnav.app.photogram.data.models.settings.AppearanceConfig;
import id.raidnav.app.photogram.data.models.settings.NotificationConfig;
import id.raidnav.app.photogram.data.models.settings.PrivacyConfig;
import id.raidnav.app.photogram.repositories.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.metrics.annotation.Timed;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Timed
@RestController
@RequestMapping("settings")
public class SettingsController {

  @Autowired
  private SettingRepository settingRepository;

  @PostMapping("/privacy/{username}")
  public ResponseEntity<PrivacyConfig> setPrivacyConfig(@PathVariable("username") String username,
                                                        @RequestBody @Validated PrivacyConfig configs) {
    return ResponseEntity.ok(settingRepository.upsertPrivacyConfig(username, configs));
  }

  @PostMapping("/appearance/{username}")
  public ResponseEntity<AppearanceConfig> setAppearance(@PathVariable("username") String username,
                                                        @RequestBody @Validated AppearanceConfig configs) {
    return ResponseEntity.ok(settingRepository.upsertAppearanceConfig(username, configs));
  }

  @PostMapping("/notifications/{username}")
  public ResponseEntity<NotificationConfig> setNotifications(@PathVariable("username") String username,
                                                             @RequestBody @Validated NotificationConfig configs) {
    return ResponseEntity.ok(settingRepository.upsertNotificationConfig(username, configs));
  }

  @PostMapping("/password/{username}")
  public ResponseEntity<Account> changePassword(@PathVariable("username") String username,
                                                @RequestBody @Validated ChangePasswordSpec spec) {
    // TODO: call auth service
    return null;
  }
}
