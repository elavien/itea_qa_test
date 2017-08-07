import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    protected WebDriver webDriver;
    /** Constructor of class
     * @param webDriver WebDriver instance
     */
    public BasePage(WebDriver webDriver){this.webDriver=webDriver;}

    /**
     * Locator for element is results of search
     */
    @FindBy(xpath ="//*[@class='g']")
    protected List<WebElement> results;

    /** Wait until some element is displayed
     * @param element The element of the page that was previously defined by the locator
     * @param timeout Waiting in seconds
     * @return Waiter
     */
    public WebElement waitUnitElementDisplayed(WebElement element, int timeout){
        WebDriverWait wait= new WebDriverWait(webDriver, timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /** Check element display
     * @param element The element of the page that was previously defined by the locator
     * @param timeout Waiting in seconds
     * @return True - if is element display, false - if is element not display after 7 sec
     */
    public boolean isElementDisplayed(WebElement element, int timeout){
        try{waitUnitElementDisplayed(element, 7).isDisplayed();}
        catch (TimeoutException e){return false;}
        return true;
    }
}
