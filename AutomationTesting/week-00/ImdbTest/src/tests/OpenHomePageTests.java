package tests;

import cases.OpenHomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpenHomePageTests {

  static WebDriver chromeDriver;
  static WebDriver firefoxDriver;
  static WebDriver safariDriver;


  @BeforeAll
  public static void setUp() {
  System.setProperty("webdriver.chrome.driver", "/Users/maitri/develop/Selenium/chromedriver");
//  System.setProperty("webdriver.gecko.driver", "/Users/maitri/develop/Selenium/geckodriver");
    chromeDriver = new ChromeDriver();
//  firefoxDriver = new FirefoxDriver();
    //safariDriver = new SafariDriver();
  }


  @Test
  public void testOpenHomePageWithChrome() {
    OpenHomePage.imdbOpen(chromeDriver, "https://www.imdb.com");
    String currentUrl = chromeDriver.getCurrentUrl();
    assertEquals("https://www.imdb.com/",currentUrl);
    //Sets the amount of time to wait for a page load to complete before throwing an error.
    // If the timeout is negative, page loads can be indefinite.
    chromeDriver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
  }


  @Test
  public void testOpenHomePageWithFirefox() {
    OpenHomePage.imdbOpen(firefoxDriver, "https://www.imdb.com");
    String currentUrl = firefoxDriver.getCurrentUrl();
    assertEquals("https://www.imdb.com/",currentUrl);
    firefoxDriver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
  }


  @Test
  public void testOpenHomePageWithSafari() {
    OpenHomePage.imdbOpen(safariDriver, "https://www.imdb.com");
    String currentUrl = safariDriver.getCurrentUrl();
    assertEquals("https://www.imdb.com/",currentUrl);
    safariDriver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
  }


  @AfterAll
  public static void testClose() {
    chromeDriver.quit();
  }

}