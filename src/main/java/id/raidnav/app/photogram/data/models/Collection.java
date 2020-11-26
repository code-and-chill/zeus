package id.raidnav.app.photogram.data.models;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class Collection {

  private String id;
  private String name;
  private List<String> postUrls;
}
