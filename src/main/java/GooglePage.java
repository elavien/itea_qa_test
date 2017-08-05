

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class GooglePage extends BasePage {

    public GooglePage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        waitUnitElementDisplayed(btnSearch, 12);}


    @FindBy(how=How.ID, id="lst-ib")
    private  WebElement fieldSearch;
    @FindBy(how=How.NAME, name="btnK")
    private WebElement btnSearch;
    @FindBy(xpath = "//*[@class='hdtb-mitem hdtb-imb']")
    private WebElement elementsAfterSearch;


   public <T> T searsh (String input){
        fieldSearch.sendKeys(input);
        btnSearch.click();
        if  (isElementDisplayed(btnSearch, 7)) {return (T) this;}
        else {return (T) PageFactory.initElements(webDriver, SearchResultsPage.class);}
    }



}
