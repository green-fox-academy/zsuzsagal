//package tests;
//
//import dataProvider.SystemDefaults;
//import enums.LinkType;
//import keywords.IssueLinking;
//import keywords.LogIn;
//import keywords.ViewIssue;
//import org.junit.*;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class IssueLinkingTest {
//
//  private static WebDriver driver;
//  private static SystemDefaults defaults = new SystemDefaults();
//  private LinkType linkType = LinkType.IS_BLOCKED_BY;
//  private static String linkToIssue = "SANDBOX-316";
//
//  @BeforeClass
//  public static void setBase() {
//    System.setProperty(defaults.getWebDriver(), defaults.getDriverPath());
//    driver = new ChromeDriver();
//  }
//
//  @Before
//  public void setUp() {
//    LogIn.setUp(driver);
//    LogIn.logIn(driver, defaults.getUserName(), defaults.getPwd(), defaults);
//    ViewIssue.goToIssue(driver, defaults.getUrl() + "/browse/SANDBOX-297", defaults);
//  }
//
//  @AfterClass
//  public static void clearUp() {
//    driver.quit();
//  }
//
//  @Test
//  public void linkIssueTest() {
//    IssueLinking.linkIssue(driver, defaults, linkType, linkToIssue);
//
//    driver.navigate().refresh();
//    Assert.assertEquals(linkToIssue, IssueLinking.getLinkedIssue(driver, defaults));
//
//    IssueLinking.deleteLinkedIssue(driver, defaults, linkToIssue);
//    driver.navigate().refresh();
//    Assert.assertTrue(IssueLinking.isExistLinkContent(driver, defaults));
//  }
//}
