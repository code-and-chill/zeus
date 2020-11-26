package id.raidnav.app.photogram.controllers.spec;

public class GetFolloweeSpec {

  private final String type;
  private final int page;
  private final int perPage;

  public GetFolloweeSpec(String type, int page, int perPage) {
    this.type = type;
    this.page = page;
    this.perPage = perPage;
  }

  public String getType() {
    return type;
  }

  public int getPage() {
    return page;
  }

  public int getPerPage() {
    return perPage;
  }
}
