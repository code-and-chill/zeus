package id.raidnav.app.photogram.controllers.spec;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ChangePasswordSpec {

  private final String oldPassword;
  private final String newPassword;
}
