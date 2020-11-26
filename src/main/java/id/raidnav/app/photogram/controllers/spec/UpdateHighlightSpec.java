package id.raidnav.app.photogram.controllers.spec;

import id.raidnav.app.photogram.data.models.Story;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateHighlightSpec {

  private String operation;
  private List<Story> stories;
}
