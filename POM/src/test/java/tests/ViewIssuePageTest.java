package tests;

import dataProvider.SystemDefaults;
import enums.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

public class ViewIssuePageTest {
  private static SystemDefaults defaults = new SystemDefaults();
  private static WebDriver driver;
  private WebDriverWait wait = new WebDriverWait(driver, defaults.getWaitTimeOut());
  private LogInPage logInPage;
  private IndexPage indexPage;
  private ViewIssuePage viewIssuePage;
  //private String quickSearch = "sandbox-275";
  private String quickSearch = "KOALA-24";
  private String desc = "Description Test";
  private String summary = "Summary Test";
  private String newAssignee = "User3";
  private StatusType statusType = StatusType.TODO;
  private IssueType issueType = IssueType.TASK;
  private Priority priority = Priority.LOW;

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
    indexPage = new IndexPage(driver, wait);
    indexPage.quickSearchByString(quickSearch);
    viewIssuePage = new ViewIssuePage(driver, wait);
  }

  @AfterClass
  public static void clearUp() {
    driver.quit();
  }

  @Test
  public void viewIssue() {
    Assert.assertEquals("sandbox", viewIssuePage.getProjectType().toLowerCase());
    Assert.assertEquals(quickSearch, viewIssuePage.getIssueKey().toLowerCase());
    Assert.assertEquals("Testing Sandbox Project name", viewIssuePage.getSummary());
    Assert.assertEquals("epic", viewIssuePage.getIssueType().toLowerCase());
    Assert.assertEquals("medium", viewIssuePage.getPriority().toLowerCase());
    Assert.assertEquals("Click to add description", viewIssuePage.getDesc());
    Assert.assertEquals("IN PROGRESS", viewIssuePage.getStatus());
    Assert.assertEquals("Unresolved", viewIssuePage.getResolution());
    Assert.assertEquals("User4", viewIssuePage.getAssignee());
  }

  @Test
  public void watchIssue() {
    viewIssuePage.setIsIssueAlreadyWatched();
    viewIssuePage.setWatchStatus(false);
    viewIssuePage.setNumberOfWatchers();
    viewIssuePage.setWatchStatus(true);
    Assert.assertEquals(viewIssuePage.getNumberOfWatchers() + 1, viewIssuePage.getWatcherCount());
    viewIssuePage.setWatchStatus(viewIssuePage.getIsIssueAlreadyWatched());
  }

  @Test
  public void addTextToDesc() {
    viewIssuePage.editDesc(desc, false);
    Assert.assertEquals(viewIssuePage.getOriginalDesc() + desc, viewIssuePage.getDesc());
    viewIssuePage.editDesc(viewIssuePage.getOriginalDesc(), true);
  }

  @Test
  public void replaceExistingDesc() {
    viewIssuePage.editDesc(desc, true);
    Assert.assertEquals(desc, viewIssuePage.getDesc());
    viewIssuePage.editDesc(viewIssuePage.getOriginalDesc(), true);
  }

  @Test
  public void addTextToSummary() {
    viewIssuePage.editSummary(summary, false);
    Assert.assertEquals(viewIssuePage.getOriginalSummary() + summary, viewIssuePage.getSummary());
    viewIssuePage.editSummary(viewIssuePage.getOriginalSummary(), true);
  }

  @Test
  public void replaceExistingSummary() {
    viewIssuePage.editSummary(summary, true);
    Assert.assertEquals(summary, viewIssuePage.getSummary());
    viewIssuePage.editSummary(viewIssuePage.getOriginalSummary(), true);
  }

  @Test
  public void selectNewAssignee() {
    viewIssuePage.selectNewAssignee(newAssignee);
    Assert.assertEquals(newAssignee, viewIssuePage.getAssignee());
    viewIssuePage.selectNewAssignee(viewIssuePage.getOriginalAssignee());
  }

  @Test
  public void setStatus() {
    viewIssuePage.setStatus(statusType);
    Assert.assertTrue(viewIssuePage.isIssueUpdMsgVisible());
    Assert.assertEquals(statusType.getValue(), viewIssuePage.getStatus());
    viewIssuePage.setStatus(StatusType.valueOf(viewIssuePage.getOriginalStatus().replaceAll("\\s+","")));
  }

  @Test
  public void editIssueType() {
    viewIssuePage.editIssueType(issueType);
    Assert.assertEquals(issueType.getValue(), viewIssuePage.getIssueType());
    viewIssuePage.editIssueType(IssueType.EPIC);
  }

  @Test
  public void editPriority() {
    viewIssuePage.editPriority(priority);
    Assert.assertEquals(priority.getValue(), viewIssuePage.getPriority());
    viewIssuePage.editPriority(Priority.MEDIUM);
  }

  @Test
  public void editUsingEditBtn() {
    viewIssuePage.editUsingEditBtn(issueType, summary, priority, newAssignee);
    Assert.assertTrue(viewIssuePage.isIssueUpdMsgVisible());
    Assert.assertEquals(issueType.getValue(), viewIssuePage.getIssueType());
    Assert.assertEquals(summary, viewIssuePage.getSummary());
    Assert.assertEquals(priority.getValue(), viewIssuePage.getPriority());
    Assert.assertEquals(newAssignee, viewIssuePage.getAssignee());
    viewIssuePage.editIssueType(IssueType.EPIC);
    viewIssuePage.editSummary(summary, true);
    viewIssuePage.editPriority(Priority.MEDIUM);
    viewIssuePage.selectNewAssignee(newAssignee);
  }
}
