@Checkout
Feature: Checkout scenarios

  Scenario: Happy path
    Given the user logins successfully
    When the user adds to Cart the products
      | name                  |
      | Sauce Labs Bike Light |
    And the user checkouts from the cart
    And the user completes checkout information
    And the user finishes the checkout
      | firstName | lastName | postalCode |
      | miguel    | peceros  | 15049      |
    Then the system shows the checkout is completed
    And the user logouts

  Scenario: Sorts from low to high
    Given the user logins successfully
    When the user sorts products by "Price(low to high)"
    Then system sorts products by price from low to high correctly

  Scenario: Add products
    Given the user logins successfully
    When the user adds to Cart the products
      | name                     |
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Onesie        |
    Then the remove button is enabled for products added

  Scenario: Prices in checkout
    Given the user logins successfully
    When the user adds to Cart the products
      | name                     |
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Onesie        |
    And the user checkouts from the cart
    Then the prices in checkout page is listed correctly














