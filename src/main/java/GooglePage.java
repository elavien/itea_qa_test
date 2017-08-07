import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends BasePage {

    /** Constructor os class
     * @param webDriver WebDriver instance
     */
    public GooglePage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        waitUnitElementDisplayed(btnSearch, 12);}

    /**
     * Field of Search
     */
    @FindBy(how=How.ID, id="lst-ib")
    private  WebElement fieldSearch;
    /**
     * Button for start search
     */
    @FindBy(how=How.NAME, name="btnK")
    private WebElement btnSearch;

    /** Method for Search
     * @param input The formal value that will be indicated in the test
     * @param <T> Generic type to be determined later
     * @return Starts a search
     */
   public <T> T searsh (String input){
        fieldSearch.sendKeys(input);
        btnSearch.click();
        if  (isElementDisplayed(btnSearch, 7)) {return (T) this;}
        else {return (T) PageFactory.initElements(webDriver, SearchResultsPage.class);}
    }

}
