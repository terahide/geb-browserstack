import geb.driver.BrowserStackDriverFactory
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

//baseUrl = "https://***.net"

waiting {
    timeout = 10
}

def browserStackBrowser = System.getProperty("geb.browserstack.browser")
if (browserStackBrowser) {
    driver = {
        def username = System.getenv("GEB_BROWSERSTACK_USERNAME")
        assert username
        def accessKey = System.getenv("GEB_BROWSERSTACK_AUTHKEY")
        assert accessKey
        new BrowserStackDriverFactory().create(browserStackBrowser, username, accessKey, ['browserstack.localIdentifier': System.getProperty('browserstack.localIdentifier')])
    }
}


//Default browser to run on local machine
environments {

    firefox {
        driver = { new FirefoxDriver() }
    }

    chrome {
        driver = { new ChromeDriver() }
    }

}

