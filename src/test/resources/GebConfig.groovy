/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.remote.DesiredCapabilities

waiting {
	timeout = 2
}

environments {
	firefox {
		driver = { new FirefoxDriver() }
	}

	phantomJS {
        driver = {
            new PhantomJSDriver(new DesiredCapabilities())
        }
    }
}
