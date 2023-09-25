package pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

  private final WebDriver webDriver;
  By userInput = By.id("user-name");
  By pwdInput = By.id("password");
  By loginBtn = By.id("login-button");
  By loginErrorMsg = By.cssSelector("[data-test='error']");

  public LoginPage(WebDriver webDriver) {
    super(webDriver);
    this.webDriver = webDriver;
  }

  public void doLogin(String usr, String pwd) {
    webDriver.findElement(userInput).sendKeys(usr);
    webDriver.findElement(pwdInput).sendKeys(pwd);
    webDriver.findElement(loginBtn).click();
  }

  public void validateThereIsNoRedirection() {
    assertThat(webDriver.getCurrentUrl()).isEqualTo(baseUrl);
  }

  public void validateRedirectionToProducts() {
    assertThat(webDriver.getCurrentUrl()).contains("/inventory");
  }

  public void validateErrorMsg(String msg) {
    assertThat(getElementTextBy(loginErrorMsg)).contains(msg);
  }
}
