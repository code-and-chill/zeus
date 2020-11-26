package id.raidnav.app.photogram.controllers;

import id.raidnav.app.photogram.data.models.Collection;
import id.raidnav.app.photogram.services.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.metrics.annotation.Timed;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Timed
@RestController
@RequestMapping("collections")
public class CollectionController {

  @Autowired
  private CollectionService collectionService;

  @PostMapping("/{username}")
  public ResponseEntity<Collection> addCollection(@PathVariable("username") String username,
                                                  @RequestBody @Validated Collection spec) {
    Collection collection = Collection.builder()
        .id(username + spec.getName())
        .name(spec.getName())
        .postUrls(spec.getPostUrls())
        .build();
    try {
      collectionService.upsert(collection);
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().build();
    }
    return ResponseEntity
        .created(URI.create("collections/" + username + "/" + collection.getName()))
        .body(collection);
  }

  @GetMapping("/{username}")
  public ResponseEntity<List<Collection>> getCollections(@PathVariable("username") String username) {
    List<Collection> collections = collectionService.getAll(username);
    return collections.size() > 0 ? ResponseEntity.ok(collections) : ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{username}&{collection_name}")
  public ResponseEntity<Collection> removeCollection(@PathVariable("username") String username,
                                                     @PathVariable("collection_name") String collectionName) {
    collectionService.delete(username + collectionName);
    return ResponseEntity.noContent().build();
  }
}
