//package tests;
//
//import dataProvider.SystemDefaults;
//import keywords.LogIn;
//import keywords.ProfilePicture;
//import org.junit.*;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class ProfilePicTest {
//  private static WebDriver driver;
//  private static SystemDefaults defaults = new SystemDefaults();
//
//  @BeforeClass
//  public static void setBase() {
//    System.setProperty(defaults.getWebDriver(), defaults.getDriverPath());
//    driver = new ChromeDriver();
//  }
//
//  @Before
//  public void setUp() {
//    driver.manage().deleteAllCookies();
//    LogIn.setUp(driver);
//    LogIn.logIn(driver, defaults.getUserName(), defaults.getPwd(), defaults);
//  }
//
//  @Test
//  public void testProfilePictureChanging() {
//    ProfilePicture.changeAvatar(driver, defaults);
//    String currentAvatarURL = ProfilePicture.getAvatar(driver, defaults);
//    ProfilePicture.selectNewAvatar(driver, defaults);
//    driver.navigate().refresh();
//    String newAvatarURL = ProfilePicture.getAvatar(driver, defaults);
//
//    Assert.assertNotEquals(currentAvatarURL, newAvatarURL);
//  }
//
//  @Test
//  public void revertProfilePicture() {
//    ProfilePicture.changeAvatar(driver, defaults);
//    String currentAvatarURL = ProfilePicture.getAvatar(driver, defaults);
//    ProfilePicture.revertAvatar(driver, defaults);
//    driver.navigate().refresh();
//    String newAvatarURL = ProfilePicture.getAvatar(driver, defaults);
//
//    Assert.assertNotEquals(currentAvatarURL, newAvatarURL);
//  }
//
//  @AfterClass
//  public static void clearUp() {
//    driver.quit();
//  }
//}
