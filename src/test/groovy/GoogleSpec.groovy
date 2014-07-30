import geb.spock.GebReportingSpec
import view.GoogleHomePage
import view.GoogleResultsPage
import view.WikipediaPage

class GoogleSpec extends GebReportingSpec {

    def "the first link should be wikipedia"() {
        when:
        to GoogleHomePage

        and:
        search.field = "wikipedia"

        then:
        at GoogleResultsPage

        and:
        firstResultLink.text() == "Wikipedia"

        when:
        firstResultLink.click()

        then:
        waitFor { at WikipediaPage }
    }

}
