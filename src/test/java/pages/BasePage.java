package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

public class BasePage {

  private final WebDriver webDriver;
  protected String baseUrl = "https://www.saucedemo.com/";
  protected Logger logger = Logger.getLogger(BasePage.class);
  private final Wait<WebDriver> defaultWait;

  public BasePage(WebDriver webDriver) {
    this.webDriver = webDriver;
    this.defaultWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
  }

  public void click(By locator) {
    waitForElement(locator);
    webDriver.findElement(locator).click();
  }

  public void type(By locator, String text) {
    waitForElement(locator);
    webDriver.findElement(locator).sendKeys(text);
  }

  public void waitForElement(By locator) {
    defaultWait.until(ExpectedConditions.presenceOfElementLocated(locator));
  }

  public void waitForElement(By locator, long seconds) {
    WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds));
    wait.until(ExpectedConditions.presenceOfElementLocated(locator));
  }

  public void navigateToLoginPage() {
    webDriver.navigate().to(baseUrl);
  }

  public boolean isWebElementDisplayed(By locator) {
    try {
      return webDriver.findElement(locator).isDisplayed();
    } catch (NoSuchElementException ignore) {
      logger.warn("locator: " + locator + " not found");
      return false;
    }
  }

  public String getElementTextBy(By locator) {
    defaultWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    return webDriver.findElement(locator).getText();
  }

  public List<WebElement> getElementsList(By locator) {
    return webDriver.findElements(locator);
  }

  public List<WebElement> getElementsList(By parentLocator, By childLocator) {
    return webDriver.findElement(parentLocator).findElements(childLocator);
  }

  public void selectOptionFromDropDownList(By locator, String textOption) {
    waitForElement(locator);
    List<WebElement> optionsList = webDriver.findElement(locator).findElements(By.cssSelector("option"));
    optionsList.stream()
        .filter(e -> e.getText().trim().equalsIgnoreCase(textOption))
        .findFirst()
        .ifPresent(WebElement::click);
  }
}
