package Pages;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductPage extends TestBase {

    @FindBy(xpath = "(//div[@class='product-item__content']/div/div/following-sibling::div//a)[1]")
    WebElement firstProduct;
   public ProductPage() {
       PageFactory.initElements(driver, this);
   }
    public void clickFirstProduct(){
       //System.out.println(firstProduct.getText());
       wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
       firstProduct.click();
    }
    public void selectProduct(){
        List<WebElement> liElements = driver.findElements(By.xpath("//div[@class='results-area']/div/ul/li"));
        WebElement ele = liElements.get(0);
        System.out.println("The value of list element is :" +ele);
    }

}
