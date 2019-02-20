//package tests;
//
//import dataProvider.SystemDefaults;
//import keywords.CommentIssue;
//import keywords.LogIn;
//import keywords.ViewIssue;
//import org.junit.*;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class CommentIssueTest {
//
//  public static WebDriver driver;
//  public static SystemDefaults defaults = new SystemDefaults();
//  private String comment = "This is an automated test comment.";
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
//  @After
//  public void cleanHistory() {
//    CommentIssue.deleteCurrentComment(driver, defaults);
//  }
//
//  @AfterClass
//  public static void clearUp() {
//    driver.quit();
//  }
//
//  @Test
//  public void CommentIssueTest() {
//    CommentIssue.addCommentToTheIssue(driver, defaults, comment);
//    driver.navigate().refresh();
//
//    Assert.assertNotEquals(CommentIssue.getCurrentComment(driver, defaults), comment);
//    Assert.assertTrue(CommentIssue.getCurrentComment(driver, defaults).contains(comment));
//  }
//}
//
