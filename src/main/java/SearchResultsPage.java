import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

    public class SearchResultsPage extends BasePage {
        /**
         * Constructor of class
         *
         * @param webDriver WebDriver instance
         */
        public SearchResultsPage(WebDriver webDriver) {
            super(webDriver);
            PageFactory.initElements(webDriver, this);
        }

        protected WebDriver webDriver;

        /**
         * Second Page of Search after the search has already produced
         */
        @FindBy(xpath = "//*[@class='fl' and text()='2']")
        private WebElement secondPage;

        /**
         * List of results of search
         *
         * @return List of webelements
         */
        public List<WebElement> getResults() {
            return results;
        }

        /**
         * Counts the number of results on one page
         *
         * @return Number of results
         */
        public int getResultsCount() {
            return getResults().size();
        }

        /**
         * The method of checking the search results for the content of some text
         *
         * @param text Some text to be set in the test
         * @return True - if the text is contained in the results, false - if it is not
         */
        public boolean isResultsContain(String text) {
            for (WebElement result : getResults()) {
                if (result.getText().toLowerCase().contains(text)) {
                    return true;
                } else return false;
            }
            return true;
        }

        /**
         * Click on the second search page
         *
         * @param i
         */
        public void goToSecondSearchPage() {
            secondPage.click();
        }

        /**
         * Verifies that the first search result contains a search query
         *
         * @param text Will input in test
         * @return True, if first result contains a search query
         */
        public boolean isResultsLoaded(String text) {
            getResults().get(0).getText().toLowerCase().contains(text);
            return true;
        }

       }
