package id.raidnav.app.photogram.repositories;

import id.raidnav.app.photogram.data.models.settings.AppearanceConfig;
import id.raidnav.app.photogram.data.models.settings.NotificationConfig;
import id.raidnav.app.photogram.data.models.settings.PrivacyConfig;

public interface SettingRepository {

  PrivacyConfig upsertPrivacyConfig(String username, PrivacyConfig config);

  AppearanceConfig upsertAppearanceConfig(String username, AppearanceConfig config);

  NotificationConfig upsertNotificationConfig(String username, NotificationConfig config);
}
