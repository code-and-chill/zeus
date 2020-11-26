package id.raidnav.app.photogram.data.models;

import lombok.*;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Highlight {

  private String name;
  private String username;
  private String imageUrl;
  private List<Story> stories;
}
