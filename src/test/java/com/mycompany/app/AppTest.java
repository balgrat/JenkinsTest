package com.mycompany.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;


public class AppTest 
{
    public static final String USERNAME = "jeroenveltmans1";
    public static final String AUTOMATE_KEY = "BwHWqoz9bA29UXwuBGmT";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
   
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void SeleniumTest()
    {
        //Connect ID test
        System.setProperty("webdriver.chrome.driver","D:\\Programs\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://127.0.0.1:8000/";

        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"page-top\"]/header/div/div/a")).click();
        System.out.println(driver.getTitle());

        driver.findElement(By.id("username")).sendKeys("jeroen.jerry@hotmail.com");
        driver.findElement(By.id("password")).sendKeys("linkedintest!");
        driver.findElement(By.id("password")).submit();

        //Add project
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/div/h5/a")).click();
        driver.findElement(By.id("id_title")).sendKeys("Test project needs to be removed!");
        driver.findElement(By.id("id_abstract")).sendKeys("This is the part where the user can write an abstract");
        driver.findElement(By.id("id_title")).submit(); //just added to wait a bit on the website to see that it is filling in some things ;)

        System.out.println("Test passed!");
        
        driver.close();
        
/*
        // declaration and instantiation of objects/variables
        //comment the above 2 lines and uncomment below 2 lines to use Chrome
        System.setProperty("webdriver.chrome.driver","D:\\Programs\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        //close Fire fox
        driver.close();
*/
    }

    @Test
    public void browserStackTest() throws Exception
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "74.0 beta");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("browserstack.debug", true);
        caps.setCapability("browserstack.networkLogs", true);
        caps.setCapability("browserstack.local", "true");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("http://127.0.0.1:8000/");

        System.out.println("next step");

        driver.findElement(By.xpath("//*[@id=\"page-top\"]/header/div/div/a")).click();

        System.out.println(driver.getTitle());
        driver.quit();
        
    }
}







