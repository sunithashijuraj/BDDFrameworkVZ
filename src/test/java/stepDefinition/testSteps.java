package stepDefinition;

import Base.TestBase;
import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.ProductPage;
import Pages.ShoppingCartPage;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class testSteps extends TestBase {
    HomePage homePage;
    ProductPage productPage;
    ProductDetailsPage productDetailsPage;
    ShoppingCartPage shoppingCartPage;

    public testSteps() throws FileNotFoundException {
        super();
        writeFile();
        browserSetUp();
        homePage = new HomePage();
        productPage = new ProductPage();
        productDetailsPage = new ProductDetailsPage();
        shoppingCartPage = new ShoppingCartPage();
    }

    @Given("I navigate to web shop")
    public void navigateTo() throws InterruptedException  {
        launchUrl();
        homePage.acceptCookies();
        homePage.closePopUp();
    }
    @When("I look for any product and go to the specific product page")
    public void goToProductPage() throws InterruptedException {
        homePage.searchProduct(prop.getProperty("keyword"));
        productPage.clickFirstProduct();
    }
    @When("I check the product price and add the product to the product shopping cart")
    public void addProductToCart() {
        productDetailsPage.getProductPrice();
        productDetailsPage.addToCart();
    }
    @When("I navigate to the shopping cart and change the quantity to {int}")
    public void changeQuantity(int newQuantity) {
        productDetailsPage.goToCart();
        shoppingCartPage.updateProductCard(newQuantity);
    }
    @Then("I add some assertions on the shopping cart")
    public void assertShoppingCart() throws InterruptedException {
        Assert.assertEquals(shoppingCartPage.verifyShoppingCartPageTitle(), "bol.com | Winkelwagentje");
        Assert.assertEquals(shoppingCartPage.noOfItemsInTheCart(), 2);
    }
    @Then("I close the website")
    public void closeWebsite() {
       driver.quit();
    }

}
