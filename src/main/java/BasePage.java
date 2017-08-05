import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver webDriver;
    public BasePage(WebDriver webDriver){this.webDriver=webDriver;}


        public WebElement waitUnitElementDisplayed(WebElement element, int timeout){
        WebDriverWait wait= new WebDriverWait(webDriver, timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));}

    public boolean isElementDisplayed(WebElement element, int timeout){
        try{waitUnitElementDisplayed(element, 7).isDisplayed();}
        catch (TimeoutException e){return false;}
        return true;}
}
