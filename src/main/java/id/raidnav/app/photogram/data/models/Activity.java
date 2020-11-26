package id.raidnav.app.photogram.data.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "activities")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Activity {

  // follow request, likes, comments, follows
  // follow request: name, accept/declined
  // likes (post): name, post_urls
  // comments (post): name, messages, post_urls
  // follow: name, their photo_urls, status

  private String type;
  private Account other;
  private Map<String, Object> contents;

}
