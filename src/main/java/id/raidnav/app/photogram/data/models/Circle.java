package id.raidnav.app.photogram.data.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "circle")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class Circle {

  private String name;
  private String username;
  private List<Account> friends;

}
