package tests;

import dataProvider.SystemDefaults;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

public class LogInPageTest {
  private final String ERROR_MSG = "Sorry, your username and password are incorrect - please try again.";
  private static SystemDefaults defaults = new SystemDefaults();
  private static WebDriver driver;
  private WebDriverWait wait = new WebDriverWait(driver, defaults.getWaitTimeOut());
  private LogInPage logInPage;
  private IndexPage indexPage;

  @BeforeClass
  public static void setBase() {
    System.setProperty(defaults.getWebDriver(), defaults.getDriverPath());
    driver = new ChromeDriver();
  }

  @Before
  public void setUp() {
    BasicPage.setUp(driver, defaults);
    logInPage = new LogInPage(driver, wait);
  }

  @AfterClass
  public static void clearUp() {
    driver.quit();
  }

  @Test
  public void logInWithValidValues() {
    logInPage.logIn(defaults.getUserName(), defaults.getPwd());
    indexPage = new IndexPage(driver, wait);
    Assert.assertEquals(defaults.getUserName(), indexPage.getLoggedInUserName());
  }

  @Test
  public void logInWithoutUserName() {
    logInPage.logIn("", defaults.getPwd());
    Assert.assertEquals(ERROR_MSG, logInPage.getLogInErrorMsg());
  }

  @Test
  public void logInWithoutPwd() {
    logInPage.logIn(defaults.getUserName(), "");
    Assert.assertEquals(ERROR_MSG, logInPage.getLogInErrorMsg());
  }

  @Test
  public void logInWithWrongPwd() {
    logInPage.logIn(defaults.getUserName(), defaults.getPwd() + "wrongPwd");
    Assert.assertEquals(ERROR_MSG, logInPage.getLogInErrorMsg());
  }
}
