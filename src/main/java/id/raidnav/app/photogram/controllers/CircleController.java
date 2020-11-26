package id.raidnav.app.photogram.controllers;

import id.raidnav.app.photogram.controllers.spec.CircleSpec;
import id.raidnav.app.photogram.data.models.Account;
import id.raidnav.app.photogram.data.models.Circle;
import id.raidnav.app.photogram.services.AccountService;
import id.raidnav.app.photogram.services.CircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.metrics.annotation.Timed;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Timed
@RestController
@RequestMapping(value = "circles")
public class CircleController {

  @Autowired
  private CircleService circleService;

  @Autowired
  private AccountService accountService;

  private final static int CIRCLE_MAX = 30;

  @PostMapping
  public ResponseEntity<Circle> addCircle(@RequestBody CircleSpec circleSpec) {
    String candidateCircleId = circleSpec.getUserName() + circleSpec.getCircleName();
    List<Circle> circles = circleService.getAll(circleSpec.getUserName());
    if (circles.size() >= CIRCLE_MAX) {
      return ResponseEntity.badRequest().build();
    } else if (circleService.get(candidateCircleId).isPresent()) {
      return ResponseEntity.unprocessableEntity().build();
    }
    return ResponseEntity
        .created(URI.create("circles/" + candidateCircleId))
        .body(circleService.addCircle(circleSpec.getUserName(), circleSpec.getCircleName()));
  }

  @GetMapping(value = "/{username}")
  public ResponseEntity<List<Circle>> getCircles(@PathVariable("username") String userName) {
    List<Circle> circles = circleService.getAll(userName);
    return circles.size() > 0 ? ResponseEntity.ok(circles) : ResponseEntity.notFound().build();
  }

  @PutMapping("/{username}&{circleName}")
  public ResponseEntity<Circle> modifyCircleName(@PathVariable("username") String userName,
                                                 @PathVariable("circleName") String circleName,
                                                 @RequestBody String proposedName) {
    return ResponseEntity.ok(circleService.modifyCircleName(userName, circleName, proposedName));
  }

  @PutMapping("/{username}&{circleName}/members")
  public ResponseEntity<Circle> modifyCircleMember(@PathVariable("username") String userName,
                                                   @PathVariable("circleName") String circleName,
                                                   @RequestBody List<String> accountNames) {
    List<Account> accounts = new ArrayList<>();
    for (String name : accountNames) {
      Optional<Account> account = accountService.get(name);
      account.ifPresent(accounts::add);
    }
    return ResponseEntity.ok(circleService.updateMembers(userName, circleName, accounts));
  }

  @DeleteMapping("/{username}&{circleName}")
  public ResponseEntity<Void> deleteCircle(@PathVariable("username") String userName,
                                           @PathVariable("circleName") String circleName) {
    circleService.delete(userName, circleName);
    return ResponseEntity.noContent().build();
  }

}
