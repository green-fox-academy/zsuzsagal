package tests;

import dataProvider.SystemDefaults;
import enums.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

public class CreateIssuePageTest {
  private static SystemDefaults defaults = new SystemDefaults();
  private static WebDriver driver;
  private WebDriverWait wait = new WebDriverWait(driver, defaults.getWaitTimeOut());
  private LogInPage logInPage;
  private IndexPage indexPage;
  private CreateIssuePage createIssuePage;
  private ViewIssuePage viewIssuePage;
  private String summary = "Testing POM";

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
  }

  @AfterClass
  public static void clearUp() {
    driver.quit();
  }

  @Test
  public void createIssue() {
    indexPage.clickCreateIssueBtn();
    createIssuePage = new CreateIssuePage(driver, wait);
    createIssuePage.createIssue(ProjectType.SANDBOX, IssueType.TASK, summary, Priority.LOWEST, true);
    createIssuePage.getNewIssuePage();
    viewIssuePage = new ViewIssuePage(driver,wait);
    Assert.assertEquals(ProjectType.SANDBOX.toString().toLowerCase(), viewIssuePage.getProjectType().toLowerCase());
    Assert.assertEquals(IssueType.TASK.toString().toLowerCase(), viewIssuePage.getIssueType().toLowerCase());
    Assert.assertEquals(summary, viewIssuePage.getSummary());
    Assert.assertEquals(Priority.LOWEST.toString().toLowerCase(), viewIssuePage.getPriority().toLowerCase());
    Assert.assertEquals(defaults.getUserName().toLowerCase(), viewIssuePage.getAssignee().toLowerCase());
  }
}
