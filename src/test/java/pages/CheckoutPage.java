package pages;

import static org.assertj.core.api.Assertions.assertThat;

import entity.CheckoutPersonalInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

  private final WebDriver webDriver;

  By checkoutBtn = By.id("checkout");
  By firstNameInput = By.id("first-name");
  By lastNameInput = By.id("last-name");
  By postalCodeInput = By.id("postal-code");
  By continueBtn = By.id("continue");
  By finishBtn = By.id("finish");
  By operationMsg = By.cssSelector(".complete-text");

  public CheckoutPage(WebDriver webDriver) {
    super(webDriver);
    this.webDriver = webDriver;
  }

  public void completeCheckout() {
    click(checkoutBtn);
  }

  public void fillPersonalInfo(CheckoutPersonalInfo personalInfo) {
    type(firstNameInput, personalInfo.getFirstName());
    type(lastNameInput, personalInfo.getLastName());
    type(postalCodeInput, personalInfo.getPostalCode());
    click(continueBtn);
    click(finishBtn);
  }

  public void validateCheckoutCompleted(String msg) {
    assertThat(getElementTextBy(operationMsg)).isEqualTo(msg);
  }
}
