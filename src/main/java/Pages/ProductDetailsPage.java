package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailsPage extends TestBase {
    @FindBy(xpath = "//span[@class='promo-price']")
    WebElement productPrice;

    @FindBy(xpath = "(//div[@id='buy-block']/div//a[@data-test='add-to-basket'])[1]")
    WebElement adCart;

    @FindBy(xpath = "//div[@class='add-on-page-header']//div/following-sibling::div/a")
    WebElement shoppingCart;
    public ProductDetailsPage() {
        PageFactory.initElements(driver, this);
    }
    public void getProductPrice(){
        String price = productPrice.getText();
        System.out.print("Price of the Selected Product: "+price);
    }
    public void addToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(adCart));
        adCart.click();
    }
    public void goToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCart));
        shoppingCart.click();
    }


}
