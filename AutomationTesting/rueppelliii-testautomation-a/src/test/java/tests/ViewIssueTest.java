package tests;

import dataProvider.SystemDefaults;
import enums.IssueType;
import enums.Priority;
import enums.ProjectType;
import keywords.ViewIssue;
import keywords.LogIn;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewIssueTest {
  private static WebDriver webDriver;

  private static SystemDefaults defaults = new SystemDefaults();

  @BeforeClass
  public static void setBase() {
    System.setProperty(defaults.getWebDriver(), defaults.getDriverPath());
    webDriver = new FirefoxDriver();
    webDriver.manage().deleteAllCookies();
  }

  @Test
  public void assertViewIssue() {
    LogIn.logIn(webDriver, defaults.getUserName(), defaults.getPwd(), defaults);
    ViewIssue.goToIssue(webDriver, defaults.getUrl()+"/browse/SANDBOX-275", defaults);

    assertEquals(ProjectType.SANDBOX.toString().toLowerCase(), ViewIssue.getProjectType(webDriver,defaults).toLowerCase());
    assertEquals("Testing Sandbox Project name", ViewIssue.getSummary(webDriver, defaults));
    assertEquals(IssueType.EPIC.toString().toLowerCase(), ViewIssue.getIssueType(webDriver, defaults).toLowerCase());
    assertEquals(Priority.MEDIUM.toString().toLowerCase(), ViewIssue.getPriority(webDriver, defaults).toLowerCase());
    assertEquals("Click to add description", ViewIssue.getDescription(webDriver, defaults));
    assertEquals("TO DO", ViewIssue.getStatus(webDriver, defaults));
    assertEquals("Unresolved", ViewIssue.getResolution(webDriver, defaults));
    assertEquals("User4", ViewIssue.getAssignee(webDriver, defaults));
  }

  @AfterClass
  public static void clearUp() {
    webDriver.quit();
  }
}

