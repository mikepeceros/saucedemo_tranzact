package stepdefs;

import static utils.Messages.CHECKOUT_COMPLETED;

import entity.CheckoutPersonalInfo;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Map;
import runner.TestRunner;

public class CheckoutSteps extends TestRunner {

  @DataTableType
  public CheckoutPersonalInfo personalInfoEntryTransformer(Map<String, String> row) {
    return new CheckoutPersonalInfo(
        row.get("firstName"), row.get("lastName"), row.get("postalCode"));
  }

  @And("the user completes checkout information")
  public void theUserCompletesCheckoutInformation() {
    checkoutPage.completeCheckout();
  }

  @And("the user finishes the checkout")
  public void theUserFinishesTheCheckout(List<CheckoutPersonalInfo> personalInfoList) {
    checkoutPage.fillPersonalInfo(personalInfoList.get(0));
  }

  @Then("the system shows the checkout is completed")
  public void theSystemShowsTheCheckoutIsCompleted() {
    checkoutPage.validateCheckoutCompleted(CHECKOUT_COMPLETED);
  }
}
