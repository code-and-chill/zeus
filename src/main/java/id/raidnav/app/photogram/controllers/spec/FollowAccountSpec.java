package id.raidnav.app.photogram.controllers.spec;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FollowAccountSpec {
  private String followee;
  private String follower;
}
