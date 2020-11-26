package id.raidnav.app.photogram.controllers;

import id.raidnav.app.photogram.controllers.response.GetAccountResponse;
import id.raidnav.app.photogram.controllers.spec.AccountSpec;
import id.raidnav.app.photogram.data.models.Account;
import id.raidnav.app.photogram.data.models.Page;
import id.raidnav.app.photogram.services.AccountService;
import id.raidnav.app.photogram.services.FolloweeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.metrics.annotation.Timed;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@Timed
@RestController
@RequestMapping(value = "accounts")
public class AccountController {

  @Autowired
  private AccountService accountService;

  @Autowired
  private FolloweeService followeeService;

  @GetMapping(value = "/{username}")
  public ResponseEntity<GetAccountResponse> getAccount(@PathVariable(value = "username") String userName) {
    Optional<Account> account = accountService.get(userName);
    if (account.isEmpty()) return ResponseEntity.notFound().build();

    Page<Account> followers = followeeService.getFollowers(userName, 1, 1);
    Page<Account> followee = followeeService.getFollowees(userName, 1, 1);

    return ResponseEntity.ok(new GetAccountResponse(account.get(), followers.getTotal(), followee.getTotal()));
  }

  @PostMapping(value = "/")
  public ResponseEntity<Account> addAccount(@RequestBody @Validated AccountSpec spec) {
    return ResponseEntity
        .created(URI.create("accounts/" + spec.getAccount().getUserName()))
        .body(accountService.create(spec.getAccount()));
  }

  @PutMapping("/{username}")
  public ResponseEntity<Account> updateAccount(@PathVariable("username") String username,
                                               @RequestBody @Validated AccountSpec spec) {
    return ResponseEntity.ok(accountService.update(username, spec.getAccount()));
  }

  @DeleteMapping("/{username}")
  public ResponseEntity<Account> deleteAccount(@PathVariable("username") String username) {
    accountService.delete(username);
    return ResponseEntity.noContent().build();
  }

}
