package tests;

import dataProvider.SystemDefaults;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

public class AdvSearchPageTest {
  private static SystemDefaults defaults = new SystemDefaults();
  private static WebDriver driver;
  private WebDriverWait wait = new WebDriverWait(driver, defaults.getWaitTimeOut());
  private LogInPage logInPage;
  private IndexPage indexPage;
  private AdvSearchPage advSearchPage;
  private ViewIssuePage viewIssuePage;
  private String query = "summary ~ test AND type = Story AND status = \"In Progress\"" +
      " AND createdDate >= \"2018-12-09\" AND createdDate < \"2018-12-10\"";

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
  public void advSearch() {
    indexPage.getSearchIssuePage();
    advSearchPage = new AdvSearchPage(driver, wait);
    advSearchPage.setSearchOnAdv();
    advSearchPage.searchByQuery(query);
    viewIssuePage = new ViewIssuePage(driver, wait);
    Assert.assertEquals(1, advSearchPage.getListOfResults().size());
    Assert.assertTrue(viewIssuePage.getSummary().toLowerCase().contains("test"));
    Assert.assertEquals("Story", viewIssuePage.getIssueType());
    Assert.assertEquals("IN PROGRESS", viewIssuePage.getStatus());
    Assert.assertEquals("2018-12-09", viewIssuePage.getCreatedDate().substring(0, 10));
  }
}
