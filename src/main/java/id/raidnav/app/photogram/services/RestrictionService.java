package id.raidnav.app.photogram.services;

import java.util.List;

public interface RestrictionService {

  void mute(String person, String target, List<String> rule);
}
