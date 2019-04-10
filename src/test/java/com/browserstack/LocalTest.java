package com.browserstack;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class LocalTest extends BrowserStackJUnitTest {

  @Test
  public void test() throws Exception {
    driver.get("http://127.0.0.1:8000/");

    driver.findElement(By.xpath("//*[@id=\"page-top\"]/header/div/div/a")).click();

  }
}
