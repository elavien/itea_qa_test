


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

    public class SearchResultsPage extends BasePage{
        public SearchResultsPage(WebDriver webDriver){
            super(webDriver);
            PageFactory.initElements(webDriver, this);
            }
        protected WebDriver webDriver;
        @FindBy(xpath ="//*[@class='g']")
        private List<WebElement> results;

        public List<WebElement> getResults() {
            return results;
        }

        public String getPageURL(){return webDriver.getCurrentUrl();}
    }
