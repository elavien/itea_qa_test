import com.gargoylesoftware.htmlunit.BrowserVersion;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class Tests {
    public WebDriver webDriver;
    BrowserVersion browser;
   public GooglePage googlePage;

    /**Initialises FirefoxDriver and navigates to Google page before each test
     */
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

    /**
     * Kill WebDriver. Close browser after each test
     */
    @AfterMethod
    public void afterMethod() {
        if (webDriver != null) {
            webDriver.quit();} }

    /**
     * Verifies that the first search result contains a search query - checks that the results page has loaded
     * Checks that the number of search queries is 7
     * Checks that each result on the page matches the search query
     * Moves to the second search page
     * Checks that the number of search queries is 7 at second search page
     * Checks that each result on the page matches the search query at second search page
     * !!!The number of search results may be 7 or 10 for each test run!!!
     */
    @Test
    public void searchTest() {
        GooglePage googlePage = PageFactory.initElements(webDriver, GooglePage.class);
        SearchResultsPage resultsPage = googlePage.searsh("ITEA");
        Assert.assertTrue(resultsPage.isResultsLoaded("itea"), "The Results of Search is not loaded");
        int resultsCount = resultsPage.getResultsCount();
        Assert.assertEquals(resultsCount, 7, "The results are not 7");
        Assert.assertTrue(resultsPage.isResultsContain("itea"));
        resultsPage.goToSecondSearchPage();
        Assert.assertEquals(resultsCount, 7, "The results are not 7");
        Assert.assertTrue(resultsPage.isResultsContain("itea"));
    }
}
