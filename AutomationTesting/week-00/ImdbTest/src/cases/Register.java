package cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Register {


  public static void imdbRegisterWithEmptyName(WebDriver webdriver) {
    WebDriverWait wait = new WebDriverWait(webdriver, 10);
    WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("imdb-signin-link")));
    signInBtn.click();
    WebElement createNewAccountBtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("create-account")));
    createNewAccountBtn.click();
    WebElement customerName = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_customer_name")));
    customerName.sendKeys("");
    WebElement customerEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_email")));
    customerEmail.sendKeys("emilyb@gmail.com");
    WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_password")));
    password.sendKeys("12AQc987");
    WebElement passwordCheck = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_password_check")));
    passwordCheck.sendKeys("12AQc987");
    WebElement createNewImdbBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
    createNewImdbBtn.click();
  }


  public static void imdbRegisterWithEmptyEmail(WebDriver webdriver) {
    WebDriverWait wait = new WebDriverWait(webdriver, 10);
    WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("imdb-signin-link")));
    signInBtn.click();
    WebElement createNewAccountBtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("create-account")));
    createNewAccountBtn.click();
    WebElement customerName = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_customer_name")));
    customerName.sendKeys("Emily Beedle");
    WebElement customerEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_email")));
    customerEmail.sendKeys("");
    WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_password")));
    password.sendKeys("12AQc987");
    WebElement passwordCheck = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_password_check")));
    passwordCheck.sendKeys("12AQc987");
    WebElement createNewImdbBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
    createNewImdbBtn.click();
  }


  public static void imdbRegisterWithInvalidEmail(WebDriver webdriver) {
    WebDriverWait wait = new WebDriverWait(webdriver, 10);
    WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("imdb-signin-link")));
    signInBtn.click();
    WebElement createNewAccountBtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("create-account")));
    createNewAccountBtn.click();
    WebElement customerName = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_customer_name")));
    customerName.sendKeys("Emily Beedle");
    WebElement customerEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_email")));
    customerEmail.sendKeys("email");
    WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_password")));
    password.sendKeys("12AQc987");
    WebElement passwordCheck = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_password_check")));
    passwordCheck.sendKeys("12AQc987");
    WebElement createNewImdbBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
    createNewImdbBtn.click();
  }


  public static void imdbRegisterWithNoPassword(WebDriver webdriver) {
    WebDriverWait wait = new WebDriverWait(webdriver, 10);
    WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("imdb-signin-link")));
    signInBtn.click();
    WebElement createNewAccountBtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("create-account")));
    createNewAccountBtn.click();
    WebElement customerName = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_customer_name")));
    customerName.sendKeys("Emily Beedle");
    WebElement customerEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_email")));
    customerEmail.sendKeys("emilyb@gmail.com");
    WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_password")));
    password.sendKeys("");
    WebElement passwordCheck = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_password_check")));
    passwordCheck.sendKeys("12AQc987");
    WebElement createNewImdbBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
    createNewImdbBtn.click();
  }


  public static void imdbRegisterWithNoPasswordCheck(WebDriver webdriver) {
    WebDriverWait wait = new WebDriverWait(webdriver, 10);
    WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("imdb-signin-link")));
    signInBtn.click();
    WebElement createNewAccountBtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("create-account")));
    createNewAccountBtn.click();
    WebElement customerName = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_customer_name")));
    customerName.sendKeys("Emily Beedle");
    WebElement customerEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_email")));
    customerEmail.sendKeys("emilyb@gmail.com");
    WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_password")));
    password.sendKeys("12AQc987");
    WebElement passwordCheck = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_password_check")));
    passwordCheck.sendKeys("");
    WebElement createNewImdbBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
    createNewImdbBtn.click();
  }

  public static void imdbRegisterWithNotMatchingPasswords(WebDriver webdriver) {
    WebDriverWait wait = new WebDriverWait(webdriver, 10);
    WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("imdb-signin-link")));
    signInBtn.click();
    WebElement createNewAccountBtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("create-account")));
    createNewAccountBtn.click();
    WebElement customerName = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_customer_name")));
    customerName.sendKeys("Emily Beedle");
    WebElement customerEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_email")));
    customerEmail.sendKeys("emilyb@gmail.com");
    WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_password")));
    password.sendKeys("12AQc987");
    WebElement passwordCheck = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_password_check")));
    passwordCheck.sendKeys("12AQc98");
    WebElement createNewImdbBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
    createNewImdbBtn.click();
  }

  public static void imdbRegisterWithShortPassword(WebDriver webdriver) {
    WebDriverWait wait = new WebDriverWait(webdriver, 10);
    WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("imdb-signin-link")));
    signInBtn.click();
    WebElement createNewAccountBtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("create-account")));
    createNewAccountBtn.click();
    WebElement customerName = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_customer_name")));
    customerName.sendKeys("Emily Beedle");
    WebElement customerEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_email")));
    customerEmail.sendKeys("emilyb@gmail.com");
    WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_password")));
    password.sendKeys("imDB2");
    WebElement passwordCheck = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_password_check")));
    passwordCheck.sendKeys("imDB2");
    WebElement createNewImdbBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
    createNewImdbBtn.click();
  }


  public static void imdbRegisterWithValidFields(WebDriver webdriver) {
    WebDriverWait wait = new WebDriverWait(webdriver, 10);
    WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("imdb-signin-link")));
    signInBtn.click();
    WebElement createNewAccountBtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("create-account")));
    createNewAccountBtn.click();
    WebElement customerName = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_customer_name")));
    customerName.sendKeys("Emily Beedle");
    WebElement customerEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_email")));
    customerEmail.sendKeys("emilyb@gmail.com");
    WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_password")));
    password.sendKeys("12AQc987");
    WebElement passwordCheck = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_password_check")));
    passwordCheck.sendKeys("12AQc987");
    WebElement createNewImdbBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
    createNewImdbBtn.click();
  }


}




