package pages;

import dataProvider.SystemDefaults;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class BasicPage {
  WebDriver driver;
  WebDriverWait wait;

  BasicPage(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
    PageFactory.initElements(driver, this);
  }

  public static void setUp(WebDriver driver, SystemDefaults defaults) {
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(defaults.getWaitTimeOut(), TimeUnit.SECONDS);
    driver.navigate().to(defaults.getUrl());
  }
}
