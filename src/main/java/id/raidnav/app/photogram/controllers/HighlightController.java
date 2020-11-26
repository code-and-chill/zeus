package id.raidnav.app.photogram.controllers;

import id.raidnav.app.photogram.controllers.spec.UpdateHighlightSpec;
import id.raidnav.app.photogram.data.models.Highlight;
import id.raidnav.app.photogram.data.models.Page;
import id.raidnav.app.photogram.services.HighlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.metrics.annotation.Timed;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Timed
@RestController
@RequestMapping(value = "highlights")
public class HighlightController {

  @Autowired
  private HighlightService highlightService;

  @GetMapping("/{username}?page={page}&per_page={perPage}")
  public ResponseEntity<Page<Highlight>> getAll(@PathVariable String username,
                                                @PathVariable int page,
                                                @PathVariable int perPage) {
    Page<Highlight> memories = highlightService.getAll(username, page, perPage);
    return ResponseEntity.ok(memories);
  }

  @PostMapping("/")
  public ResponseEntity<Highlight> create(@RequestBody Highlight highlight) {
    Highlight h = highlightService.create(highlight);
    return ResponseEntity
        .created(URI.create("highlights/" + highlight.getName()))
        .body(h);
  }

  @PutMapping("/{name}")
  public ResponseEntity<Highlight> modify(@PathVariable("name") String name, @RequestBody UpdateHighlightSpec spec) {
    switch (spec.getOperation().toLowerCase()) {
      case "add":
        return ResponseEntity.ok(highlightService.addStory(name, spec.getStories()));
      case "remove":
        return ResponseEntity.ok(highlightService.eraseStory(name, spec.getStories()));
      default:
        return ResponseEntity.badRequest().build();
    }
  }

  @DeleteMapping("/{name}&{username}")
  public ResponseEntity<Highlight> delete(@PathVariable("name") String name,
                                          @PathVariable("username") String username) {
    highlightService.remove(name, username);
    return ResponseEntity.noContent().build();
  }
}
