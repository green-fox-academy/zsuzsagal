package tests;

import cases.OpenHomePage;
import cases.Register;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest {

  static WebDriver chromeDriver;
  static WebDriver firefoxDriver;

  static WebDriverWait wait;
  static List<WebDriver> drivers = new ArrayList<>();


  @BeforeAll
  public static void setUp() {
    System.setProperty("webdriver.chrome.driver", "/Users/maitri/develop/Selenium/chromedriver");
    System.setProperty("webdriver.gecko.driver", "/Users/maitri/develop/Selenium/geckodriver");

    chromeDriver = new ChromeDriver();
    firefoxDriver = new FirefoxDriver();

    ///wait = new WebDriverWait(chromeDriver, 10);
    drivers.add(chromeDriver);
    drivers.add(firefoxDriver);

  }


  @Test
  public void testRegisterOnImdbWithEmptyName() {
    for (WebDriver driver: drivers) {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      OpenHomePage.imdbOpen(driver, "https://www.imdb.com/");
      Register.imdbRegisterWithEmptyName(driver);
      WebElement authErrorMsgBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("auth-error-message-box")));
      String authErrorMsg = authErrorMsgBox.getText();
      assertEquals("There was a problem\nEnter your name", authErrorMsg);
    }
  }


  @Test
  public void testRegisterOnImdbWithEmptyEmail() {
    for (WebDriver driver : drivers) {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      OpenHomePage.imdbOpen(chromeDriver, "https://www.imdb.com/");
      Register.imdbRegisterWithEmptyEmail(chromeDriver);
      WebElement authErrorMsgBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("auth-error-message-box")));
      String authErrorMsg = authErrorMsgBox.getText();
      assertEquals("There was a problem\nEnter your email", authErrorMsg);
    }
  }


  @Test
  public void testRegisterOnImdbWithInvalidEmail() {
    OpenHomePage.imdbOpen(chromeDriver, "https://www.imdb.com/");
    Register.imdbRegisterWithInvalidEmail(chromeDriver);
    WebElement authErrorMsgBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("auth-error-message-box")));
    String authErrorMsg = authErrorMsgBox.getText();
    assertEquals("There was a problem\nEnter a valid email address", authErrorMsg);
  }


  @Test
  public void testRegisterOnImdbWithEmptyPassword() {
    OpenHomePage.imdbOpen(chromeDriver, "https://www.imdb.com/");
    Register.imdbRegisterWithNoPassword(chromeDriver);
    WebElement authErrorMsgBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("auth-error-message-box")));
    String authErrorMsg = authErrorMsgBox.getText();
    assertEquals("There was a problem\nPasswords must match", authErrorMsg);
  }

  @Test
  public void testRegisterOnImdbWithEmptyPasswordCheck() {
    OpenHomePage.imdbOpen(chromeDriver, "https://www.imdb.com/");
    Register.imdbRegisterWithNoPasswordCheck(chromeDriver);
    WebElement authErrorMsgBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("auth-error-message-box")));
    String authErrorMsg = authErrorMsgBox.getText();
    assertEquals("There was a problem\nPasswords must match", authErrorMsg);
  }

  @Test
  public void testRegisterOnImdbWithNotMatchingPasswords() {
    OpenHomePage.imdbOpen(chromeDriver, "https://www.imdb.com/");
    Register.imdbRegisterWithNotMatchingPasswords(chromeDriver);
    WebElement authErrorMsgBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("auth-error-message-box")));
    String authErrorMsg = authErrorMsgBox.getText();
    assertEquals("There was a problem\nPasswords must match", authErrorMsg);
  }


  @Test
  public void testRegisterOnImdbWithShortPassword() {
    OpenHomePage.imdbOpen(chromeDriver, "https://www.imdb.com/");
    Register.imdbRegisterWithShortPassword(chromeDriver);
    WebElement authErrorMsgBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("auth-error-message-box")));
    String authErrorMsg = authErrorMsgBox.getText();
    assertEquals("There was a problem\nPasswords must be at least 8 characters.", authErrorMsg);
  }


  @Test
  public void testRegisterAlreadyHaveAccount() {
    OpenHomePage.imdbOpen(chromeDriver, "https://www.imdb.com/");
    Register.imdbRegisterWithValidFields(chromeDriver);
    WebElement authErrorMsgBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("auth-error-message-box")));
    String authErrorMsg = authErrorMsgBox.getText();
    String emailFieldValue = chromeDriver.findElement(By.id("ap_email")).getAttribute("value");
    assertEquals("Important Message!\nYou indicated you are a new customer, but an account already exists with the e-mail "+ emailFieldValue, authErrorMsg);
  }


  @Test
  public void testRegisterOnImdbWithValidFields() {
    OpenHomePage.imdbOpen(chromeDriver, "https://www.imdb.com/");
    Register.imdbRegisterWithValidFields(chromeDriver);
  }


  @AfterAll
  public static void testClose() {
    chromeDriver.quit();
    firefoxDriver.quit();
  }
}
