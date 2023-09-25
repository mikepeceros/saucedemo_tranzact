package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideBarPage extends BasePage {

  private final WebDriver webDriver;

  By allItemsMenuItem = By.id("inventory_sidebar_link");
  By aboutMenuItem = By.id("about_sidebar_link");
  By logoutMenuItem = By.id("logout_sidebar_link");
  By resetAppMenuItem = By.id("reset_sidebar_link");

  public SideBarPage(WebDriver webDriver) {
    super(webDriver);
    this.webDriver = webDriver;
  }

  public void doLogout() {
    click(logoutMenuItem);
  }
}
