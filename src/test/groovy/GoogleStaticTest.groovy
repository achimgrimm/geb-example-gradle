import geb.content.SimplePageContent
import geb.junit4.GebReportingTest
import groovy.transform.CompileStatic
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import view.GoogleHomePage
import view.GoogleResultsPage
import view.GoogleSearchModule

@RunWith(JUnit4)
@CompileStatic
class GoogleStaticTest extends GebReportingTest {

    @Test
    void theFirstLinkShouldBeWikipedia() {
        // to GoogleHomePage
        GoogleHomePage googleHomePage = (GoogleHomePage) browser.to(GoogleHomePage)
        // search.field = "wikipedia"
        GoogleSearchModule googleSearchModule = (GoogleSearchModule) googleHomePage.getContent("search")
        SimplePageContent field = (SimplePageContent) googleSearchModule.getContent("field")
        field.value("wikipedia")
        // at GoogleResultsPage
        GoogleResultsPage resultPage = (GoogleResultsPage) browser.at(GoogleResultsPage)
        //assert firstResultLink.text() == "Wikipedia"
        SimplePageContent firstResultLink = (SimplePageContent) resultPage.getContent("firstResultLink")
        assert firstResultLink.text() == "Wikipedia"
        // firstResultLink.click()
        firstResultLink.click()
    }

}
