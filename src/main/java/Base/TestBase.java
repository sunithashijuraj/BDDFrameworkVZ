package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static ChromeOptions options;
    public static File file;
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream file = new FileInputStream("C:/Users/sunit/Documents/SeleniumProject"
                    + "/BDDShoppingTest/src/main/java/Config/config.properties");
            prop.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void browserSetUp(){
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = WebDriverManager.chromedriver().capabilities(options).create();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    public void launchUrl() {
        driver.get(prop.getProperty("url"));
        System.out.println("Navigated to Bol WebShop Page");
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void writeFile() throws FileNotFoundException {
        file = new File("target/sample.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);
    }

}
