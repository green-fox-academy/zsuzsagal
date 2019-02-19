package tests;

import dataProvider.SystemDefaults;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

public class ProjectVersionPageTest {

  private static SystemDefaults defaults = new SystemDefaults();
  private static WebDriver driver;
  private WebDriverWait wait = new WebDriverWait(driver, defaults.getWaitTimeOut());
  private LogInPage logInPage;
  private IndexPage indexPage;
  private ViewIssuePage viewIssuePage;
  private ProjectVersionPage projectVersionPage;
  private String versionNameVal = "Version1";
  private String versionStartDateVal = "16/Feb/19";
  private String versionReleaseDateVal = "28/Feb/19";
  private String versionDescVal = "Description1";
  private String editVersionNameVal = "Version1-Edited";
  private String editVersionStartDateVal = "19/Feb/19";
  private String editVersionReleaseDateVal = "09/Mar/21";
  private String editVersionDescVal = "Description1-edited";

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
    indexPage.quickSearchByString("KOALA-24");
    viewIssuePage = new ViewIssuePage(driver, wait);
  }

  @AfterClass
  public static void clearUp() {
    driver.quit();
  }

  @Test
  public void crudVersion() {
    viewIssuePage.goToProjectSettings();
    projectVersionPage = new ProjectVersionPage(driver, wait);
    projectVersionPage.createVersion(versionNameVal, versionStartDateVal, versionReleaseDateVal, versionDescVal);
    Assert.assertEquals(versionNameVal, projectVersionPage.getVersionName());
    Assert.assertEquals(versionStartDateVal, projectVersionPage.getVersionStartDate());
    Assert.assertEquals(versionReleaseDateVal, projectVersionPage.getVersionReleaseDate());
    Assert.assertEquals(versionDescVal, projectVersionPage.getVersionDesc());
    viewIssuePage.goToVersionInGlassDoc();
    projectVersionPage = new ProjectVersionPage(driver, wait);
    projectVersionPage.clickOnVersionInGlassDoc();
    Assert.assertEquals(versionNameVal, projectVersionPage.getVersionName());
    Assert.assertEquals(versionStartDateVal, projectVersionPage.getVersionStartDate());
    Assert.assertEquals(versionReleaseDateVal, projectVersionPage.getVersionReleaseDate());
    Assert.assertEquals(versionDescVal, projectVersionPage.getVersionDesc());
    viewIssuePage.goToProjectSettings();
    projectVersionPage = new ProjectVersionPage(driver, wait);
    projectVersionPage.editVersion(editVersionNameVal, editVersionStartDateVal, editVersionReleaseDateVal, editVersionDescVal);
    Assert.assertEquals(editVersionNameVal, projectVersionPage.getVersionName());
    Assert.assertEquals(editVersionStartDateVal, projectVersionPage.getVersionStartDate());
    Assert.assertEquals(editVersionReleaseDateVal, projectVersionPage.getVersionReleaseDate());
    Assert.assertEquals(editVersionDescVal, projectVersionPage.getVersionDesc());
    viewIssuePage.goToVersionInGlassDoc();
    projectVersionPage = new ProjectVersionPage(driver, wait);
    projectVersionPage.clickOnVersionInGlassDoc();
    Assert.assertEquals(editVersionNameVal, projectVersionPage.getVersionName());
    Assert.assertEquals(editVersionStartDateVal, projectVersionPage.getVersionStartDate());
    Assert.assertEquals(editVersionReleaseDateVal, projectVersionPage.getVersionReleaseDate());
    Assert.assertEquals(editVersionDescVal, projectVersionPage.getVersionDesc());
    viewIssuePage.goToProjectSettings();
    projectVersionPage = new ProjectVersionPage(driver, wait);
    projectVersionPage.deleteVersion();
    Assert.assertEquals(null, projectVersionPage.getVersionName());
    viewIssuePage.goToVersionInGlassDoc();
    projectVersionPage = new ProjectVersionPage(driver, wait);
    projectVersionPage.clickOnVersionInGlassDoc();
    Assert.assertEquals(null, projectVersionPage.getVersionName());
    }

}
