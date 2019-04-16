package com.browserstack;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SingleTest extends BrowserStackJUnitTest {

  @Test
  public void test() throws Exception {
    driver.get("http://connectid.pythonanywhere.com/");

    driver.findElement(By.xpath("//*[@id=\"page-top\"]/header/div/div/a")).click();

    Thread.sleep(2000);

    assertEquals("LinkedIn Login, LinkedIn Sign in | LinkedIn", driver.getTitle());

    driver.findElement(By.id("username")).sendKeys("jeroen.jerry@hotmail.com");
    driver.findElement(By.id("password")).sendKeys("linkedintest!");
    driver.findElement(By.id("password")).submit();

    assertEquals("Connect-ID", driver.getTitle());

    driver.get("http://connectid.pythonanywhere.com/projects");

    //Add project
    driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/div/h5/a")).click();
    driver.findElement(By.id("id_title")).sendKeys("Test project needs to be removed!");
    driver.findElement(By.id("id_abstract")).sendKeys("This is the part where the user can write an abstract");



    Thread.sleep(2000);

    assertEquals("Connect-ID", driver.getTitle());

  }
}
