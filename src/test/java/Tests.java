
import com.gargoylesoftware.htmlunit.BrowserVersion;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;


public class Tests {
    public WebDriver webDriver;
    BrowserVersion browser;
   public GooglePage googlePage;


    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(@Optional ("firefox") String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            FirefoxDriverManager.getInstance().setup();
            webDriver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("The Browser Type is Undefined");}
        webDriver.navigate().to("https://www.google.com.ua");
        }

    @AfterMethod
    public void afterMethod() {
        if (webDriver != null) {
            webDriver.quit();} }

    @Test
    public void searchTest(){
      GooglePage googlePage = new GooglePage(webDriver);
      googlePage.searsh("ITEA");



    }
}
