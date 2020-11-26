package id.raidnav.app.photogram.data.models;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Story {

  private String id;
  private String mediaUrl;
  private boolean shareAllowed;
  private boolean replyAllowed;
}
