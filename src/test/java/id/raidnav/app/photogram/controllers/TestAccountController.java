package id.raidnav.app.photogram.controllers;

import id.raidnav.app.photogram.controllers.response.GetAccountResponse;
import id.raidnav.app.photogram.controllers.spec.AccountSpec;
import id.raidnav.app.photogram.data.models.Account;
import id.raidnav.app.photogram.data.models.Gender;
import id.raidnav.app.photogram.data.models.Page;
import id.raidnav.app.photogram.services.AccountService;
import id.raidnav.app.photogram.services.FolloweeService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Optional;

@Test
public class TestAccountController {

  @InjectMocks
  private AccountController controller;

  @Mock
  private AccountService account;

  @Mock
  private FolloweeService followee;

  private Account data;

  @BeforeMethod
  public void initMocks() {
    MockitoAnnotations.initMocks(this);
    data = Account.builder()
        .username("foobar")
        .bio("happy person")
        .gender("MALE")
        .phoneNumber("+1234567890")
        .build();
  }

  @Test
  public void testGetAccount() {
    Mockito.doReturn(Optional.of(Account.builder().username("raidnav").build())).when(account).get("raidnav");
    Mockito.doReturn(new Page<Account>(new ArrayList<>(), 143L, 1, 1)).when(followee).getFollowers("raidnav", 1, 1);
    Mockito.doReturn(new Page<Account>(new ArrayList<>(), 67L, 1, 1)).when(followee).getFollowees("raidnav", 1, 1);

    ResponseEntity<GetAccountResponse> response = controller.getAccount("raidnav");

    Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    Assert.assertEquals(response.getBody().getAccount(), Account.builder().username("raidnav").build());
    Assert.assertEquals(response.getBody().getNumFollowees(), Long.valueOf(67));
    Assert.assertEquals(response.getBody().getNumFollowers(), Long.valueOf(143));
  }

  @Test
  public void testCreateAccount() {
    Mockito.doReturn(data).when(account).create(data);

    ResponseEntity<Account> response = controller.addAccount(data);

    Assert.assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    Assert.assertEquals(response.getBody(), data);
  }

  @Test
  public void testModifyAccount() {
    Mockito.doReturn(data).when(account).update("foobar", data);
    ResponseEntity<Account> response = controller.updateAccount("foobar", new AccountSpec(data));

    Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    Assert.assertEquals(response.getBody(), data);
  }

  @Test
  public void testDeleteAccount() {
    ResponseEntity<Account> response = controller.deleteAccount("foobar");
    Assert.assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
  }
}
