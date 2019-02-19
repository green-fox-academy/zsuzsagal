package casesForJira;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ViewIssue {

  // solution: itt ez a static WebDriver nem kell, hanem be kellett adni az egyes methodoknak kulon parameterkent
  // miert kell a wait-et minden methodban ujat letrehozni ?


  //static WebDriver webdriver = new ChromeDriver();
  static WebDriverWait wait;


  //  login to Sandbox:
  public static void login(WebDriver webdriver, String loginUrl) {
    WebDriverWait wait = new WebDriverWait(webdriver, 10);
    webdriver.get(loginUrl);
    WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-form-username")));
    username.sendKeys("user4");
    WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-form-password")));
    password.sendKeys("GreenPass123");
    WebElement loginSubmitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));
    loginSubmitBtn.click();
  }

  public static String getProjectName(WebDriver webDriver){
    wait = new WebDriverWait(webDriver,10);
    WebElement projectName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("project-name-val")));
    return projectName.getText();
  }

  public static String getSummary(WebDriver webDriver){
    wait = new WebDriverWait(webDriver,10);
    WebElement summary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("summary-val")));
    return summary.getText();
  }

  public static String getType(WebDriver webDriver) {
    wait = new WebDriverWait(webDriver,10);
    WebElement type = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("type-val")));
    return type.getText();
  }

  public static String getPriority(WebDriver webDriver){
    wait = new WebDriverWait(webDriver,10);
    WebElement priority = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("priority-val")));
    return priority.getText();
  }

  public static String getDescription(WebDriver webDriver){
    wait = new WebDriverWait(webDriver,10);
    WebElement description = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("description-val")));
    return description.getText();
  }

  public static String getStatus(WebDriver webDriver){
    wait = new WebDriverWait(webDriver,10);
    WebElement status = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("status-val")));
    return status.getText();
  }

  public static String getResolution(WebDriver webDriver){
    wait = new WebDriverWait(webDriver,10);
    WebElement resolution = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resolution-val")));
    return resolution.getText();
  }

  public static String getAssignee(WebDriver webDriver){
    wait = new WebDriverWait(webDriver,10);
    WebElement assignee = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("assignee-val")));
    return assignee.getText();
  }


}





