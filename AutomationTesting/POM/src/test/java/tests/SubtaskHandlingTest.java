//package tests;
//
//import dataProvider.SystemDefaults;
//import keywords.LogIn;
//import keywords.SubtaskHandling;
//import keywords.ViewIssue;
//import org.junit.*;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class SubtaskHandlingTest {
//
//  private static WebDriver driver;
//  private static SystemDefaults defaults = new SystemDefaults();
//  private static String summary = "Test: creating sub-task.";
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
//    ViewIssue.goToIssue(driver, defaults.getUrl() + "/browse/MOUNTAIN-85", defaults);
//  }
//
//  @After
//  public void cleanHistory() {
//    SubtaskHandling.deleteSubTask(driver, defaults);
//  }
//
//  @AfterClass
//  public static void clearUp() {
//    driver.quit();
//  }
//
//  @Test
//  public void fillSubTaskTest() {
//    SubtaskHandling.fillSubTask(driver, defaults, summary);
//    SubtaskHandling.getNewSubTask(driver, defaults);
//
//    driver.navigate().refresh();
//    Assert.assertEquals(SubtaskHandling.getNewSubTask(driver, defaults), summary);
//  }
//}
