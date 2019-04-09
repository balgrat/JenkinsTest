import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Demo {

    public static final String USERNAME = "jeroenveltmans1";
    public static final String AUTOMATE_KEY = "BwHWqoz9bA29UXwuBGmT";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static void main(String[] args) throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "74.0 beta");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("browserstack.debug", true);
        caps.setCapability("browserstack.networkLogs", true);

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("BrowserStack");
        element.submit();

        System.out.println(driver.getTitle());
        driver.quit();

    }
    
    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println("Is this part also executed if we add the @Test annotation?");
        assertTrue( true );
    }
}
