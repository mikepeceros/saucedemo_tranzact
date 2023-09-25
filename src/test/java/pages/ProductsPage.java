package pages;

import java.util.List;

import entity.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {

  private final WebDriver webDriver;

  By inventoryItemDesc = By.cssSelector(".inventory_item_description");
  By inventoryItemName = By.cssSelector(".inventory_item_name");

  By inventoryItemBtn = By.cssSelector(".btn_inventory");
  By addItemBtn = By.cssSelector("[data-test*='add-to-cart']");
  By removeItemBtn = By.cssSelector("[data-test*='remove']");
  By cartIcon = By.id("shopping_cart_container");
  By sortSelect = By.cssSelector(".product_sort_container");

  public ProductsPage(WebDriver webDriver) {
    super(webDriver);
    this.webDriver = webDriver;
  }

  public void addProduct(String productName) {
    List<WebElement> productCardsList = getElementsList(inventoryItemDesc);
    for (WebElement productCard : productCardsList) {
      WebElement w = productCard.findElement(inventoryItemName);
      if (w.getText().equals(productName)) {
        productCard.findElement(addItemBtn).click();
        break;
      }
    }
  }

  public void removeProduct(String productName) {
    List<WebElement> productCardsList = getElementsList(inventoryItemDesc);
    for (WebElement productCard : productCardsList) {
      WebElement w = productCard.findElement(inventoryItemName);
      if (w.getText().equals(productName)) {
        productCard.findElement(removeItemBtn).click();
        break;
      }
    }
  }

  public void checkoutCart() {
    click(cartIcon);
  }

  public void sortProductsBy(String text) {
    click(sortSelect);
    selectOptionFromDropDownList(sortSelect, text);
  }

  public void validateProductsAreSorted(String sortBy){
    List<WebElement> productCards = getElementsList(inventoryItemDesc);

    switch(sortBy.toLowerCase()){
      case "NAME (Z TO A)":

      case "PRICE (LOW TO HIGH)":

      case "PRICE (HIGH TO LOW)":

      default:
    }
  }
}
