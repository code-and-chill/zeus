package id.raidnav.app.photogram.controllers;

import id.raidnav.app.photogram.controllers.spec.FollowAccountSpec;
import id.raidnav.app.photogram.controllers.spec.GetFolloweeSpec;
import id.raidnav.app.photogram.data.models.Account;
import id.raidnav.app.photogram.data.models.Page;
import id.raidnav.app.photogram.services.AccountService;
import id.raidnav.app.photogram.services.FolloweeService;
import id.raidnav.app.photogram.services.RestrictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.metrics.annotation.Timed;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Timed
@RestController
@RequestMapping("followee")
public class FolloweeController {

  @Autowired
  private AccountService accountService;

  @Autowired
  private RestrictionService restrictionService;

  @Autowired
  private FolloweeService followeeService;

  @PostMapping("/")
  public ResponseEntity<Account> follow(@RequestBody @Validated FollowAccountSpec spec) {
    Optional<Account> a = accountService.get(spec.getFollowee());
    Optional<Account> b = accountService.get(spec.getFollower());
    if (a.isPresent() && b.isPresent()) {
      followeeService.followAccount(a.get(), b.get());
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.unprocessableEntity().build();
  }

  @GetMapping("/{username}")
  public ResponseEntity<Page<Account>> getFollowee(@PathVariable("username") String username,
                                                   @RequestBody @Validated GetFolloweeSpec spec) {
    Page<Account> accounts;
    switch (spec.getType()) {
      case "following": accounts = followeeService.getFollowees(username, spec.getPage(), spec.getPerPage()); break;
      case "follower": accounts = followeeService.getFollowers(username, spec.getPage(), spec.getPerPage()); break;
      default: return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(accounts);
  }

  @PostMapping("/restrict")
  public ResponseEntity<Account> restrict(@RequestBody @Validated String body) {
    restrictionService.mute("", body, new ArrayList<>());
    return null;
  }
}
