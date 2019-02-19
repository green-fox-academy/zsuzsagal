package tests;

import dataProvider.SystemDefaults;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

public class LoggedOutPageTest {
  private static SystemDefaults defaults = new SystemDefaults();
  private static WebDriver driver;
  private WebDriverWait wait = new WebDriverWait(driver, defaults.getWaitTimeOut());
  private LogInPage logInPage;
  private IndexPage indexPage;
  private LoggedOutPage loggedOutPage;

  @BeforeClass
  public static void setBase() {
    System.setProperty(defaults.getWebDriver(), defaults.getDriverPath());
    driver = new ChromeDriver();
  }

  @Before
  public void setUp() {
    BasicPage.setUp(driver, defaults);
    logInPage = new LogInPage(driver, wait);
    logInPage.logIn(defaults.getUserName(), defaults.getPwd());
  }

  @AfterClass
  public static void clearUp() {
    driver.quit();
  }

  @Test
  public void logOut() {
    indexPage = new IndexPage(driver, wait);
    indexPage.logOut();
    loggedOutPage = new LoggedOutPage(driver, wait);
    Assert.assertTrue(loggedOutPage.isLogOutMsgVisible());
    Assert.assertTrue(loggedOutPage.isUnableToAccessProfileMsgVisible(driver, defaults));
  }
}
