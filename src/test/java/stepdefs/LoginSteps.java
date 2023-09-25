package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import runner.TestRunner;

public class LoginSteps extends TestRunner {

  @Given("the user goes to saucedemo login page")
  public void theUserGoesToSaucedemoLoginPage() {
    loginPage.navigateToLoginPage();
  }

  @When("the user logins with creds {string} {string}")
  public void theUserLoginsWithCreds(String user, String pwd) {
    loginPage.doLogin(user, pwd);
  }

  @Then("the system redirects to home page")
  public void theSystemRedirectsToHomePage() {
    loginPage.validateRedirectionToProducts();
  }

  @Given("the user logins successfully")
  public void theUserLoginsSuccessfully() {
    loginPage.navigateToLoginPage();
    loginPage.doLogin("standard_user", "secret_sauce");
  }

  @Then("Login is not allowed")
  public void loginIsNotAllowed() {
    loginPage.validateThereIsNoRedirection();
  }

  @And("The error message {string} is displayed in the Login")
  public void theErrorMessageIsDisplayedInTheLogin(String arg0) {
    loginPage.validateErrorMsg(arg0);
  }
}
