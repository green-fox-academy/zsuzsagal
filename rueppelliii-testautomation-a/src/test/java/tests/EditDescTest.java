package tests;

import dataProvider.SystemDefaults;
import keywords.EditDesc;
import keywords.LogIn;
import keywords.ViewIssue;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditDescTest {
  private static WebDriver webDriver;
  private static SystemDefaults defaults = new SystemDefaults();

  @BeforeClass
  public static void setBase() {
    System.setProperty(defaults.getWebDriver(), defaults.getDriverPath());
    webDriver = new ChromeDriver();
  }

  @Before
  public void setUp() {
    webDriver.manage().deleteAllCookies();
    LogIn.setUp(webDriver);
    LogIn.logIn(webDriver, defaults.getUserName(), defaults.getPwd(), defaults);
    ViewIssue.goToIssue(webDriver, defaults.getUrl()+"/browse/JTA-54", defaults);
  }

  @Test
  public void assertReplaceExistingDesc() {
    String descText = "description text";
    EditDesc.replaceExistingDesc(webDriver, defaults, descText);
    EditDesc.isAlertPresent(webDriver);
    Assert.assertEquals(descText, ViewIssue.getDescription(webDriver, defaults));
  }

  @Test
  public void assertAddTextToDesc() {
    String existingText = ViewIssue.getDescription(webDriver, defaults);
    String addText = "and some additional text";
    EditDesc.addTextToDesc(webDriver, defaults, addText);
    EditDesc.isAlertPresent(webDriver);
    Assert.assertEquals(existingText + " " + addText, ViewIssue.getDescription(webDriver, defaults));
  }

  @AfterClass
  public static void clearUp() {
    webDriver.quit();
  }
}
