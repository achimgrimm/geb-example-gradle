import geb.junit4.GebReportingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import view.GoogleHomePage
import view.GoogleResultsPage
import view.WikipediaPage

@RunWith(JUnit4)
class GoogleTest extends GebReportingTest {

    @Test
    void theFirstLinkShouldBeWikipedia() {
        to GoogleHomePage
        search.field = "wikipedia"

        // wait for the change to results page to happen
        // (google updates the page without a new request)
        at GoogleResultsPage

        // is the first link to wikipedia?
        assert firstResultLink.text() == "Wikipedia"

        // click the link
        firstResultLink.click()

        // wait for the result page and assert it
        waitFor { at WikipediaPage }
    }

}
