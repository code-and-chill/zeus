package id.raidnav.app.photogram.data.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Page<T> {

  private List<T> data;
  private Long total;
  private int currentPage;
  private int perPage;
}

