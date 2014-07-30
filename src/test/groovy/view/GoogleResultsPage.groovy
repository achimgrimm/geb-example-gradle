package view

import geb.Page

class GoogleResultsPage extends Page {
    static at = { results }
    static content = {
        // reuse our previously defined module
        search { module GoogleSearchModule, buttonValue: "Search" }

        // content definitions can compose and build from other definitions
        results(wait: true) { $("li.g") }
        result { i -> results[i] }
        resultLink { i -> result(i).find("a.l")[0] }
        firstResultLink { resultLink(0) }
    }
}
