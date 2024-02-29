package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends TestBase {

    @FindBy(xpath = "//div[@class='consent-modal-ofc__footer modal__footer h-flex h-flex-wrap']/button[contains(text(),'Alles accepteren')][2]")
    WebElement acceptCookies;
    @FindBy(xpath = "//div[@class='modal__window js_modal_window']/button")
    WebElement popUp;
    @FindBy(xpath = "//wsp-search-input[@class='wsp-search-form__input']//input[@id='searchfor']")
    WebElement searchBox;
    @FindBy(xpath = "//button[@class='wsp-search__btn']")
    WebElement searchBtn;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookies));
        acceptCookies.click();
    }
    public void closePopUp() throws InterruptedException {
        //Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(popUp));
        popUp.click();
    }
    public String verifyHomePageTitle(){
        String title = getPageTitle();
        System.out.println("Title of the Home Page is: "+title);
        return title;
    }
    public void searchProduct(String productName) throws InterruptedException {
       // Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchBox.sendKeys(productName);
        searchBtn.click();
    }

}