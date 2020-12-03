package id.raidnav.app.photogram.repositories.impl;

import id.raidnav.app.photogram.data.models.settings.AppearanceConfig;
import id.raidnav.app.photogram.data.models.settings.NotificationConfig;
import id.raidnav.app.photogram.data.models.settings.PrivacyConfig;
import id.raidnav.app.photogram.repositories.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SettingRepositoryImpl implements SettingRepository {

  @Autowired
  private MongoTemplate mongoTemplate;

  @Override
  public PrivacyConfig upsertPrivacyConfig(String username, PrivacyConfig config) {
    return mongoTemplate.save(config);
  }

  @Override
  public AppearanceConfig upsertAppearanceConfig(String username, AppearanceConfig config) {
    return mongoTemplate.save(config);
  }

  @Override
  public NotificationConfig upsertNotificationConfig(String username, NotificationConfig config) {
    return mongoTemplate.save(config);
  }
}
