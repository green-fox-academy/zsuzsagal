//package tests;
//
//import dataProvider.SystemDefaults;
//import keywords.*;
//import org.junit.*;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//public class AtchHandlerTest {
//
//  private static WebDriver webDriver;
//  private static SystemDefaults defaults = new SystemDefaults();
//
//  @BeforeClass
//  public static void setBase() {
//    System.setProperty(defaults.getWebDriver(), defaults.getDriverPath());
//    webDriver = new ChromeDriver();
//  }
//
//  @Before
//  public void setUp() {
//    LogIn.setUp(webDriver);
//    LogIn.logIn(webDriver, defaults.getUserName(), defaults.getPwd(), defaults);
//    ViewIssue.goToIssue(webDriver, defaults.getUrl() + "/projects/KOALA/issues/KOALA-24?filter=allopenissues", defaults);
//  }
//
//  @Test
//  public void assertAtchFile() {
//    Path path = Paths.get("/Users/maitri/develop/forJira.txt");
//    AtchHandler.atchFile(webDriver, defaults);
//    Assert.assertEquals(path.getFileName().toString(), AtchHandler.getAtchFileName());
//  }
//
//  @Test
//  public void assertDeleteAtch() {
//    AtchHandler.deleteAtch(webDriver, defaults);
//    Assert.assertEquals(null, AtchHandler.getAtchFileName());
//  }
//}
