package tests;

import cases.Login;
import cases.OpenHomePage;
import cases.Register;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTests {

  static WebDriver chromeDriver;
  static WebDriver firefoxDriver;
  static WebDriver safariDriver;
  WebDriverWait wait = new WebDriverWait(chromeDriver, 10);

  @BeforeAll
  public static void setUp() {
    System.setProperty("webdriver.chrome.driver", "/Users/maitri/develop/Selenium/chromedriver");
//  System.setProperty("webdriver.gecko.driver", "/Users/maitri/develop/Selenium/geckodriver");
    chromeDriver = new ChromeDriver();
//  firefoxDriver = new FirefoxDriver();
    //safariDriver = new SafariDriver();
  }


  @Test
  public void testLoginWithValidFields() {
    OpenHomePage.imdbOpen(chromeDriver, "https://www.imdb.com/");
    Login.imdbLoginWithValidFields(chromeDriver);

  }

  @AfterAll
  public static void testClose() {
    chromeDriver.quit();
    firefoxDriver.quit();
  }

}
