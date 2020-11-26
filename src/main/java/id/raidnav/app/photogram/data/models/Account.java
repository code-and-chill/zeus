package id.raidnav.app.photogram.data.models;

import lombok.*;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "accounts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Account implements Serializable {

  @Id
  private String userName;
  @Indexed
  private String realName;
  private String website;
  private String bio;
  private String email;
  private String phoneNumber;
  private Gender gender;
  private String photoUrl;
  private DateTime bornDate;
  private AccountType type;
  private DateTime createdAt;
  private DateTime updatedAt;
}



