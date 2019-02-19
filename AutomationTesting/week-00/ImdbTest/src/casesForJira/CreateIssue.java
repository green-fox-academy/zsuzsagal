package casesForJira;


import enums.IssueType;
import enums.ProjectType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class CreateIssue {

  static Map<String, String> newIssueMap = new HashMap<>();
  static WebDriverWait wait;



  //login to Sandbox:
  public static void loginToSandbox(WebDriver webdriver, String loginUrl) {
    wait = new WebDriverWait(webdriver, 10);
    webdriver.get(loginUrl);
    WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-form-username")));
    username.sendKeys("user4");
    WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-form-password")));
    password.sendKeys("GreenPass123");
    WebElement loginSubmitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));
    loginSubmitBtn.click();
  }


  //ENUM-kent beadni meg neki ertekeket:
// Create new issue:
  //itt a webdrivert en adtam be kuklon, es a new wait-et is
  public static Map<String, String> createNewIssue(WebDriver webDriver, WebDriverWait wait) {
    wait = new WebDriverWait(webDriver, 10);
    WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("create_link")));
    createButton.click();

    WebElement projectField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("project-field")));
    String projectFieldValue = ProjectType.SANDBOX.toString();
    projectField.sendKeys(projectFieldValue,Keys.ENTER);
    newIssueMap.put("projectField", projectFieldValue);


    WebElement issueTypeField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("issuetype-field")));
    String issueTypeFieldValue = IssueType.EPIC.toString();
    issueTypeField.sendKeys(issueTypeFieldValue,Keys.ENTER);
    newIssueMap.put("issueTypeField", issueTypeFieldValue);


    WebElement summary = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("summary")));
    summary.sendKeys("As a Manager, I want to see that user story has been validated.");
    newIssueMap.put("summary", "As a Manager, I want to see that user story has been validated");

    WebElement description = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("description")));
    description.sendKeys("Documentation updates to be handled by tech writers.");
    newIssueMap.put("description", "Documentation updates to be handled by tech writers.");

    WebElement epicname = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customfield_10104")));
    epicname.click();;
    epicname.sendKeys("My new Epic");
    newIssueMap.put("epicname", "My new Epic");

    WebElement priority = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("priority-field")));
    priority.sendKeys("Low");
    newIssueMap.put("priority", "Low");

    WebElement assignToMe = wait.until(ExpectedConditions.elementToBeClickable(By.id("assign-to-me-trigger")));
    assignToMe.click();
    newIssueMap.put("assignToMe", "User4");

    WebElement createIssueSubmit = wait.until(ExpectedConditions.elementToBeClickable(By.id("create-issue-submit")));
    createIssueSubmit.click();

    return newIssueMap;

  }


}




//  public static String getTitleValue(WebDriverWait wait){
//    titleValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("summary-val")));
//    //return titleValue.getText();
//    return titleValue.getAttribute("textContent");
//  }
//
//
//  public static String getDescriptionValue(WebDriverWait wait){
//    descriptionValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("description-val")));
//    return descriptionValue.getText();
//
//  }


//  public static void findElementsOnView(WebDriver webdriver) {
//    WebDriverWait wait = new WebDriverWait(webdriver, 10);
//
//    //WebElement titleValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("summary-val")));
//    // WebElement descriptionValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("description-val")));
//    WebElement type = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='issuedetails']/li[1]/div/strong")));
//    WebElement typeValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("type-val")));
//    WebElement priority = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='issuedetails']/li[1]/div/strong")));
//    WebElement priorityValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("priority-val")));
//    WebElement labels = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='wrap-labels']/strong")));
//    WebElement labelsValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("labels-13622-value")));
//    WebElement status = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='issuedetails']/li[2]/div/strong")));
//    WebElement statusValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("status-val")));
//    WebElement resolution = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='issuedetails']/li[4]/div/strong")));
//    WebElement resolutionValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resolution-val")));
//    WebElement assignee = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='peopledetails']/li/dl[1]/dt")));
//    WebElement assigneeValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("assignee-val")));
//
//
//
//  }




