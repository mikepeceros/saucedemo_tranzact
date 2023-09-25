package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepdefs"},
    tags = "@smoke2",
    plugin = {
      "pretty",
      "json:target/cucumber-reports/cucumber.json",
      "html:target/cucumber-reports.html"
    })
public class TestRunner extends AbstractTestNGCucumberTests {

  private RemoteWebDriver webDriver;
  protected static LoginPage loginPage;
  protected static ProductsPage productsPage;
  protected static CheckoutPage checkoutPage;
  //private String browser = "EDGE";

  public void initPages(RemoteWebDriver webDriver) {
    loginPage = new LoginPage(webDriver);
    productsPage = new ProductsPage(webDriver);
    checkoutPage = new CheckoutPage(webDriver);
  }

  @BeforeTest
  @Parameters({"browser"})
  public void startBrowser(@Optional String browser) {
    switch (browser.toUpperCase()) {
      case "CHROME":
        startChrome();
        break;
      case "FIREFOX":
        startFirefox();
        break;
      case "EDGE":
        startEdge();
        break;
      case "None":
        break;
    }
  }

  @AfterTest
  @Parameters({"browser"})
  public void quitDriver(String browser) {
    try {
      if (!browser.equals("None")) webDriver.quit();
    } catch (WebDriverException e) {
      //
    }
  }

  public RemoteWebDriver startChrome() {
    try {
      ChromeOptions chromeOptions = new ChromeOptions();
      // capabilities

      WebDriverManager.chromedriver().setup();
      webDriver = new ChromeDriver(chromeOptions);
      // webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      webDriver.manage().window().maximize();
      initPages(webDriver);
    } catch (Exception e) {
      // log exception
    }
    return webDriver;
  }

  public RemoteWebDriver startFirefox() {
    try {
      String drivePath =
          "C:\\Users\\Mike\\PersonalProjects\\Saucedemo\\src\\test\\resources\\drivers\\geckodriver.exe";
      System.setProperty("webdriver.gecko.driver", drivePath);

      FirefoxOptions firefoxOptions = new FirefoxOptions();
      // capabilities

      // WebDriverManager.firefoxdriver().setup();
      webDriver = new FirefoxDriver(firefoxOptions);
      webDriver.manage().window().maximize();
      initPages(webDriver);
    } catch (Exception e) {
      // log exception
    }
    return webDriver;
  }

  public RemoteWebDriver startEdge() {
    try {
      EdgeOptions edgeOptions = new EdgeOptions();
      // capabilities

      WebDriverManager.edgedriver().setup();
      webDriver = new EdgeDriver(edgeOptions);
      webDriver.manage().window().maximize();
      initPages(webDriver);
    } catch (Exception e) {
      // log exception
    }
    return webDriver;
  }

  /*    @Override
  @DataProvider(parallel = true)
  public Object[][] scenarios() {
      return super.scenarios();
  }*/

}
