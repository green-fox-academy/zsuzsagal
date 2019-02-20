//package tests;
//
//import dataProvider.SystemDefaults;
//import enums.IssueType;
//import enums.ProjectType;
//import keywords.BasicSearch;
//import keywords.LogIn;
//import keywords.ViewIssue;
//import org.junit.*;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

//public class BasicSearchTest {
//
//    private static WebDriver driver;
//    private static SystemDefaults defaults = new SystemDefaults();
//
//    @BeforeClass
//    public static void setBase() {
//        System.setProperty(defaults.getWebDriver(), defaults.getDriverPath());
//        driver = new ChromeDriver();
//    }
//
//    @Before
//    public void setUp() {
//        driver.manage().deleteAllCookies();
//        LogIn.setUp(driver);
//        LogIn.logIn(driver, defaults.getUserName(), defaults.getPwd(), defaults);
//    }
//
//    @AfterClass
//    public static void clearUp() {
//        driver.quit();
//    }
//
//    @Test
//    public void search() {
//        BasicSearch.filteredSearch(driver, defaults,  "Koala", "task", "to do", "User4");
//
//        Assert.assertEquals(ProjectType.KOALA.getStringValue().toLowerCase(), ViewIssue.getProjectType(driver, defaults).toLowerCase());
//        Assert.assertEquals(IssueType.TASK.toString().toLowerCase(), ViewIssue.getIssueType(driver, defaults).toLowerCase());
//        Assert.assertEquals("TO DO", ViewIssue.getStatus(driver, defaults));
//        Assert.assertEquals("User4", ViewIssue.getAssignee(driver, defaults));
//        Assert.assertEquals(1, BasicSearch.validateSize(driver, defaults));
//    }
//}