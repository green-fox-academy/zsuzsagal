package tests;

import dataProvider.SystemDefaults;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import keywords.LogIn;
import keywords.LogOut;

public class LogOutTest {
  private static WebDriver driver;
  private static SystemDefaults defaults = new SystemDefaults();

  @BeforeClass
  public static void setBase() {
    System.setProperty(defaults.getWebDriver(), defaults.getDriverPath());
    driver = new ChromeDriver();
  }

  @Before
  public void setUp() {
    LogIn.setUp(driver);
    LogIn.logIn(driver, defaults.getUserName(), defaults.getPwd(), defaults);
  }

  @After
  public void cleanHistory() {
    driver.manage().deleteAllCookies();
  }

  @AfterClass
  public static void clearUp() {
    driver.quit();
  }

  @Test
  public void logOut() {
    LogOut.logOut(driver, defaults);
    Assert.assertFalse(LogOut.isLoggedInUserMenuVisible(driver));
    Assert.assertFalse(LogOut.getViewProfilePage(driver, defaults));
  }
}
