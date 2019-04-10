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

    Thread.sleep(5000);

    assertEquals("LinkedIn Login, LinkedIn Sign in | LinkedIn", driver.getTitle());
  }
}
