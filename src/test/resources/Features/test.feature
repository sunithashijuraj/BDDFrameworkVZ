Feature: Shopping Feature
  Verify the Add Shopping Cart Functionality

  Scenario Outline: Add a product to a shopping cart in a web shop
    Given I navigate to web shop
    When I look for any product and go to the specific product page
    And I check the product price and add the product to the product shopping cart
    And I navigate to the shopping cart and change the quantity to <cartQuantity>
    Then I add some assertions on the shopping cart
    And I close the website
    Examples:
    |cartQuantity|
    |2           |