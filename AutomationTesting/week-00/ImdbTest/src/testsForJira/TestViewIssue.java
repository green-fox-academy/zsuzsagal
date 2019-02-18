package testsForJira;

import casesForJira.CreateIssue;
import casesForJira.FindElementsOnView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class TestDashboardLoaded {

  static WebDriver chromeDriver;
  static Map<String, String> createdIssue;
  WebDriverWait wait = new WebDriverWait(chromeDriver, 10);

  @BeforeAll
  public static void setUp() {
    System.setProperty("webdriver.chrome.driver", "/Users/maitri/develop/Selenium/chromedriver");
    chromeDriver = new ChromeDriver();
  }


  //testing login, and getting to my own Dashboard
  @Test
  public void testDashboardLoaded() {
    CreateIssue.loginToSandbox(chromeDriver, "https://jira.greenfox.codecanvas.hu/secure/Dashboard.jspa");
    chromeDriver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
    String currentUrl = chromeDriver.getCurrentUrl();
    assertEquals("https://jira.greenfox.codecanvas.hu/secure/Dashboard.jspa", currentUrl);
    WebElement dashboardItemTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gadget-10002-title")));
    assertEquals("Assigned to Me", dashboardItemTitle.getText());
  }


  //testing login, getting to own Dashboard, and clicking on first link
  // How can I give a general link for each issue?
  @Test
  public void testViewIssue() {
    CreateIssue.loginToSandbox(chromeDriver, "https://jira.greenfox.codecanvas.hu/secure/Dashboard.jspa");
    //WebElement issueKey = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='gadget-10002']/div/div/issuetable-web-component/table/tbody/tr/td[2]/a")));
    WebElement issue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='gadget-10002']/div/div/issuetable-web-component/table/tbody/tr[2]/td[2]/a")));
    issue.click();

    String issueKeyValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("issue-link"))).getAttribute("data-issue-key");
    String currentUrl = chromeDriver.getCurrentUrl();
    assertEquals("https://jira.greenfox.codecanvas.hu/browse/" + issueKeyValue, currentUrl);

  }


  //testing create new issue and assert elements
  @Test
  public void testCreateNewIssue() {
    CreateIssue.loginToSandbox(chromeDriver, "https://jira.greenfox.codecanvas.hu/secure/Dashboard.jspa");
    WebElement issue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='gadget-10002']/div/div/issuetable-web-component/table/tbody/tr/td[2]/a")));
    issue.click();
    createdIssue = CreateIssue.createNewIssue(wait);
    //check with assert if there is any error

    // projectActualValue:
    String projectActualValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("project-name-val"))).getText();
    assertEquals(createdIssue.get("projectField"), projectActualValue);

    // issueTypeField
    String issueTypeActualValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("type-val"))).getText();
    assertEquals(createdIssue.get("issueTypeField"), issueTypeActualValue);

    // summary:
    String summaryActualValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("summary-val"))).getText();
    assertEquals(createdIssue.get("summary"), summaryActualValue);

    // description
    String descriptionActualValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("user-content-block"))).getText();
    assertEquals(createdIssue.get("description"), descriptionActualValue);

    // priority
    String priorityActualValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("priority-val"))).getText();
    assertEquals(createdIssue.get("priority"), priorityActualValue);

    // priority
    // assignee Id may not work, since User4 is hardcoded:
    String assigneeActualValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("issue_summary_assignee_user4"))).getText();
    assertEquals(createdIssue.get("assignToMe"), assigneeActualValue);

  }


  @Test
  public void assertViewIssue() {
    CreateIssue.loginToSandbox(chromeDriver, "https://jira.greenfox.codecanvas.hu/secure/Dashboard.jspa");
    WebElement issue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='gadget-10002']/div/div/issuetable-web-component/table/tbody/tr/td[2]/a")));
    issue.click();
    assertEquals("GFA - Jira Test Automation", FindElementsOnView.getProjectName());
    assertEquals("Summary2", FindElementsOnView.getSummary());
    assertEquals("Story",FindElementsOnView.getType());
    assertEquals("Medium",FindElementsOnView.getPriority());
    assertEquals("Read tutorial on katalon",FindElementsOnView.getDescription());
    assertEquals("To Do",FindElementsOnView.getStatus());
    assertEquals("Unresolved",FindElementsOnView.getResolution());
    assertEquals("User4",FindElementsOnView.getAssignee());

  }


//  @AfterAll
//  public static void testClose() {
//    chromeDriver.quit();
//  }


}



//package testsForJira;
//
//        import casesForJira.FindElementsOnView;
//        import casesForJira.LoginToJira;
//        import org.junit.jupiter.api.BeforeAll;
//        import org.junit.jupiter.api.Test;
//        import org.openqa.selenium.By;
//        import org.openqa.selenium.WebDriver;
//        import org.openqa.selenium.WebElement;
//        import org.openqa.selenium.chrome.ChromeDriver;
//        import org.openqa.selenium.support.ui.ExpectedConditions;
//        import org.openqa.selenium.support.ui.WebDriverWait;
//        import java.util.concurrent.TimeUnit;
//
//        import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class TestFindElementsOnViewchangedName {
//
//  static WebDriver chromeDriver;
//  WebDriverWait wait = new WebDriverWait(chromeDriver, 10);
//
//  @BeforeAll
//  public static void setUp() {
//    System.setProperty("webdriver.chrome.driver", "/Users/maitri/develop/Selenium/chromedriver");
//    chromeDriver = new ChromeDriver();
//  }
//
//
//  @Test
//  public void testFindTitleOnView() {
//    LoginToJira.loginToSandbox(chromeDriver, "https://jira.greenfox.codecanvas.hu/secure/Dashboard.jspa");
//    WebElement issueKey = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='gadget-10002']/div/div/issuetable-web-component/table/tbody/tr/td[2]/a")));
//    issueKey.click();
//    assertEquals("View issue: As a tester, I want to view an issue, so that I can check the details.", FindElementsOnView.getTitleValue());
//
//  }
//
//
//  @Test
//  public void testFindDescriptionOnView() {
//    LoginToJira.loginToSandbox(chromeDriver, "https://jira.greenfox.codecanvas.hu/secure/Dashboard.jspa");
//    WebElement issueKey = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='gadget-10002']/div/div/issuetable-web-component/table/tbody/tr/td[2]/a")));
//    issueKey.click();
//    assertEquals("Acceptance Criteria: Make sure page is loaded and expected element presents.\n" +
//            "Definition of Done: The issue and its details are viewable." , FindElementsOnView.getDescriptionValue());
//
//  }
//


//  @AfterAll
//  public static void testClose() {
//    chromeDriver.quit();
//  }

