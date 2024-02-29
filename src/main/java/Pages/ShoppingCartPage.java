package Pages;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage extends TestBase {
    String productPrice;
    String postalPrice;
    public int finalCartPrice;
    @FindBy(xpath = "//select[@name='quantity']")
    WebElement productQuantity;

    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    public int updateProductCard(int newCartValue) {
        Select cartValue = new Select(productQuantity);
        WebElement oldValue = cartValue.getFirstSelectedOption();
        int currentValue = Integer.parseInt(oldValue.getText());
        System.out.println("Cart Value before update: " + currentValue);

        cartValue.selectByVisibleText(String.valueOf(newCartValue));
        WebElement newValue = cartValue.getFirstSelectedOption();
        int updatedValue = Integer.parseInt(newValue.getText());
        System.out.println("Cart Value after update: " + updatedValue);
        return updatedValue;
    }

    public String verifyShoppingCartPageTitle() {
        String title = getPageTitle();
        System.out.println("The title of the Shopping Cart Page is: " + title);
        return title;
    }
    public int noOfItemsInTheCart() throws InterruptedException {
        WebElement spanElement =  driver.findElement(By.cssSelector("span.c-cost-table__definition"));
        Thread.sleep(5000);
        // Get the value of the 'data-amount' attribute
        int dataAmountValue = Integer.parseInt(spanElement.getAttribute("data-amount"));
        // Print the attribute value
        Thread.sleep(5000);
        System.out.println("Total Number of Items in the Cart: " + dataAmountValue);
        return dataAmountValue;
    }

    public int finalPriceOnScreen(){
        WebElement finalPrice = driver.findElement(By.xpath("(//div[@class='c-cost-table__value'])[3]"));
        finalCartPrice = Integer.parseInt(finalPrice.getText());
        System.out.println("The final price to be paid : "+finalCartPrice);
        return finalCartPrice;
    }
}