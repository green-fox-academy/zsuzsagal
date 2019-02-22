package pages;

import enums.IssueType;
import enums.Priority;
import enums.StatusType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewIssuePage extends BasicPage {
  private int numberOfWatchers;
  private boolean isIssueAlreadyWatched;
  private String issueUpdMsgXpath = "//*[@id=\"aui-flag-container\"]/div/div";
  private String originalDesc;
  private String originalSummary;
  private String originalAssignee;
  private String originalStatus;

  @FindBy(id = "project-name-val")
  private WebElement projectType;
  @FindBy(id = "key-val")
  private WebElement issueKey;
  @FindBy(id = "summary-val")
  private WebElement summary;
  @FindBy(id = "type-val")
  private WebElement issueType;
  @FindBy(id = "priority-val")
  private WebElement priority;
  @FindBy(id = "description-val")
  private WebElement desc;
  @FindBy(id = "status-val")
  private WebElement status;
  @FindBy(id = "resolution-val")
  private WebElement resolution;
  @FindBy(id = "assignee-val")
  private WebElement assignee;
  @FindBy(id = "assign-issue")
  private WebElement assignBtn;
  @FindBy(xpath = "//*[@id=\"created-val\"]/time")
  private WebElement createdDate;
  @FindBy(id = "watcher-data")
  private WebElement watcherCount;
  @FindBy(id = "watching-toggle")
  private WebElement watchingToggle;
  @FindBy(id = "action_id_11")
  private WebElement todoBtn;
  @FindBy(id = "action_id_21")
  private WebElement inProgBtn;
  @FindBy(id = "action_id_31")
  private WebElement doneBtn;
  @FindBy(id = "edit-issue")
  private WebElement editIssueBtn;

  public ViewIssuePage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public String getProjectType() {
    return projectType.getText();
  }

  public String getIssueKey() {
    return issueKey.getText();
  }

  public String getSummary() {
    return summary.getText();
  }

  public String getIssueType() {
    return issueType.getText();
  }

  public String getPriority() {
    return priority.getText();
  }

  public String getDesc() {
    return desc.getText();
  }

  public String getStatus() {
    return status.getText();
  }

  public String getResolution() {
    return resolution.getText();
  }

  public String getAssignee() {
    return assignee.getText();
  }

  public String getCreatedDate() {
    return createdDate.getAttribute("datetime");
  }

  public int getWatcherCount() {
    return Integer.parseInt(watcherCount.getText());
  }

  public int getNumberOfWatchers() {
    return numberOfWatchers;
  }

  public boolean getIsIssueAlreadyWatched() {
    return isIssueAlreadyWatched;
  }

  public String getOriginalDesc() {
    return originalDesc;
  }

  public String getOriginalSummary() {
    return originalSummary;
  }

  public String getOriginalAssignee() {
    return originalAssignee;
  }

  public String getOriginalStatus() {
    return originalStatus;
  }

  private boolean isIssueAlreadyWatched() {
    return watchingToggle.getAttribute("class").equals("watch-state-on");
  }

  public boolean isIssueUpdMsgVisible() {
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(issueUpdMsgXpath)));
    return driver.findElement(By.xpath(issueUpdMsgXpath)).isDisplayed();
  }

  public void setNumberOfWatchers() {
    numberOfWatchers = getWatcherCount();
  }

  public void setIsIssueAlreadyWatched() {
    isIssueAlreadyWatched = isIssueAlreadyWatched();
  }

  public void setWatchStatus(boolean watchStatus) {
    if ((watchStatus && !isIssueAlreadyWatched()) || (!watchStatus && isIssueAlreadyWatched())) {
      watchingToggle.click();
      driver.navigate().refresh();
    }
  }

  public void setStatus(StatusType status) {
    originalStatus = getStatus();
    if (status.getValue().equals("TO DO")) {
      todoBtn.click();
    } else if (status.getValue().equals("IN PROGRESS")) {
      inProgBtn.click();
    } else if (status.getValue().equals("DONE")){
      doneBtn.click();
    }
  }

  public void selectNewAssignee(String assignee) {
    assignBtn.click();
    originalAssignee = this.assignee.getText();
    WebElement assigneeInputField = wait.until(ExpectedConditions.elementToBeClickable(By.id("assignee-field")));
    assigneeInputField.clear();

    if (assigneeInputField.getText().equals("")) {
      assigneeInputField.sendKeys(assignee);
      assigneeInputField.submit();
    }
    driver.navigate().refresh();
    AlertHandler.isAlertPresent(driver);
  }

  public void editDesc(String desc, boolean isReplaceWholeDesc) {
    this.desc.click();
    WebElement descTextArea = wait.until(ExpectedConditions.elementToBeClickable(By.id("description")));
    originalDesc = descTextArea.getText();
    descTextArea.clear();

    if (descTextArea.getText().equals("") && !isReplaceWholeDesc) {
      descTextArea.sendKeys(originalDesc + desc);
    } else if (descTextArea.getText().equals("") && isReplaceWholeDesc) {
      descTextArea.sendKeys(desc);
    }
    descTextArea.submit();
    driver.navigate().refresh();
    AlertHandler.isAlertPresent(driver);
  }

  public void editSummary(String summary, boolean isReplaceWholeSummary) {
    this.summary.click();
    originalSummary = this.summary.getText();
    WebElement summaryTextArea = wait.until(ExpectedConditions.elementToBeClickable(By.id("summary")));
    summaryTextArea.clear();

    if (summaryTextArea.getText().equals("") && !isReplaceWholeSummary) {
      summaryTextArea.sendKeys(originalSummary + summary, Keys.ENTER);
    } else if (summaryTextArea.getText().equals("") && isReplaceWholeSummary) {
      summaryTextArea.sendKeys(summary, Keys.ENTER);
    }
    driver.navigate().refresh();
    AlertHandler.isAlertPresent(driver);
  }

  public void editIssueType(IssueType issueType) {
    this.issueType.click();
    WebElement issueTypeField = wait.until(ExpectedConditions.elementToBeClickable(By.id("issuetype-field")));
    issueTypeField.clear();
    issueTypeField.sendKeys(issueType.toString());
    issueTypeField.submit();
    driver.navigate().refresh();
    AlertHandler.isAlertPresent(driver);
  }

  public void editPriority(Priority priority) {
    this.priority.click();
    WebElement priorityField = wait.until(ExpectedConditions.elementToBeClickable(By.id("priority-field")));
    priorityField.clear();
    priorityField.sendKeys(priority.toString());
    priorityField.submit();
    driver.navigate().refresh();
    AlertHandler.isAlertPresent(driver);
  }

  public void editUsingEditBtn(IssueType issueType, String summary, Priority priority, String assignee) {
    editIssueBtn.click();

    WebElement editIssue = wait.until(ExpectedConditions.elementToBeClickable(By.id("issuetype-field")));
    editIssue.click();
    editIssue.clear();
    editIssue.sendKeys(issueType.toString());

    WebElement editSummary = wait.until(ExpectedConditions.elementToBeClickable(By.id("summary")));
    editSummary.clear();
    editSummary.sendKeys(summary);

    WebElement editPriority = wait.until(ExpectedConditions.elementToBeClickable(By.id("priority-field")));
    editPriority.clear();
    editPriority.sendKeys(priority.toString());

    WebElement editAssignee = wait.until(ExpectedConditions.elementToBeClickable(By.id("assignee-field")));
    editAssignee.clear();
    editAssignee.sendKeys(assignee);
    editAssignee.submit();
  }

  public void goToProjectSettings() {
    Actions action = new Actions(driver);
    WebElement sidebarFooter =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content']/div[1]/div/div[2]")));
    action.moveToElement(sidebarFooter);
    WebElement projectSettings =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content']/div[1]/div/div[2]/a[1]")));
    action.moveToElement(projectSettings);
    projectSettings.click();
  }

  public void goToVersionInGlassDoc() {
    Actions action = new Actions(driver);
    WebElement sidebar =  wait.until(ExpectedConditions.elementToBeClickable(By.className("aui-sidebar-body")));
    action.moveToElement(sidebar);
    WebElement glassDoc =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-id='sidebar-navigation-panel']/ul/li[7]/a")));
    action.moveToElement(glassDoc);
    glassDoc.click();
  }

}
