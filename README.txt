TESTING GOOGLE SEARCH - Java Maven project

TESTS:
- Verifies that the first search result contains a search query.
- Checks that the number of search queries is 7
- Checks that each result on the page matches the search query
- Moves to the second search page
- Checks that the number of search queries is 7 at second search page
- Checks that each result on the page matches the search query at second search page
- !!!The number of search results may be 7 or 10 for each test run!!!

Geckodriver for Mozilla FireFox is used with Webdrivermanager (plugin) - it does not require manual installation on a PC.

Plugins:
        - org.apache.maven.plugins
        - org.seleniumhq.selenium
        - org.testng
        
(Windows 10, IntellijIDEA)
