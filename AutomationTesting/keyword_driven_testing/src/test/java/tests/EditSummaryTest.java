package tests;

import dataProvider.SystemDefaults;
import keywords.EditSummary;
import keywords.LogIn;
import keywords.ViewIssue;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditSummaryTest {

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
  public void assertReplaceExistingSummary() {
    String summaryText = "new summary text";
    EditSummary.replaceExistingSummary(webDriver,defaults, summaryText);
    Assert.assertEquals(summaryText, ViewIssue.getSummary(webDriver, defaults));
  }

  @Test
  public void assertAddTextToSummary() {
    String existingText = ViewIssue.getSummary(webDriver, defaults);
    String addText = "addition to summary";
    EditSummary.addTextToSummary(webDriver, defaults, addText);
    Assert.assertEquals(existingText + " " + addText, ViewIssue.getSummary(webDriver, defaults));
  }

  @Test
  public void assertNoTextToSummary() {
    String summaryText = "";
    EditSummary.replaceExistingSummary(webDriver,defaults, summaryText);
    Assert.assertEquals("You must specify a summary of the issue.", EditSummary.getErrorMsgForEmptySummary(webDriver, defaults));
  }

  @Test
  public void assertReplaceExistingSummaryUsingEditIcon() {
    String summaryText = "new summary text using icon";
    EditSummary.replaceExistingSummaryUsingEditIcon(webDriver,defaults, summaryText);
    Assert.assertEquals(summaryText, ViewIssue.getSummary(webDriver, defaults));
  }

  @AfterClass
  public static void clearUp() {
    webDriver.quit();
  }
}
