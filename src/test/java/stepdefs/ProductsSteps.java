package stepdefs;

import entity.Product;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.math.NumberUtils;
import runner.TestRunner;

public class ProductsSteps extends TestRunner {

  @DataTableType
  public Product productEntryTransformer(Map<String, String> row) {
    return new Product(row.get("name"), row.get("info"), NumberUtils.toDouble(row.get("price")));
  }

  @When("the user adds to Cart the products")
  public void theUserAddsToCartTheProducts(List<Product> products) {
    for (Product product : products) {
      productsPage.addProduct(product.getName());
    }
  }

  @And("the user checkouts from the cart")
  public void theUserCheckoutsFromTheCart() {
    productsPage.checkoutCart();
  }

  @When("the user sorts products by {string}")
  public void theUserSortsProductsBy(String arg0) {
    productsPage.sortProductsBy(arg0);
  }

  @Then("system sorts products by price from low to high correctly")
  public void systemSortsProductsByPriceFromLowToHighCorrectly() {
    productsPage.validateProductsAreSorted("PRICE (LOW TO HIGH)");
  }
}
