package pages;

import enums.IssueType;
import enums.Priority;
import enums.ProjectType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateIssuePage extends BasicPage {
  private String popUpWindowMsgXpath = "//div[@id='aui-flag-container']/div/div/a";

  @FindBy(id = "project-field")
  private WebElement projectTypeInput;
  @FindBy(id = "issuetype-field")
  private WebElement issueTypeInput;
  @FindBy(id = "summary")
  private WebElement summaryInput;
  @FindBy(id = "priority-field")
  private WebElement priorityInput;
  @FindBy(id = "assign-to-me-trigger")
  private WebElement assignToMeBtn;
  @FindBy(id = "create-issue-submit")
  private WebElement submitBtn;

  public CreateIssuePage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  private void setProjectTypeInput(ProjectType projectType) {
    projectTypeInput.clear();

    if (projectTypeInput.getText().equals("")) {
      projectTypeInput.sendKeys(projectType.toString(), Keys.ENTER);
    }
  }

  private void setIssueTypeInput(IssueType issueType) {
    wait.until(ExpectedConditions.elementToBeClickable(issueTypeInput));
    issueTypeInput.clear();

    if (issueTypeInput.getText().equals("")) {
      issueTypeInput.sendKeys(issueType.toString(), Keys.ENTER);
    }
  }

  private void setSummaryInput(String summary) {
    wait.until(ExpectedConditions.elementToBeClickable(summaryInput));
    summaryInput.clear();

    if (summaryInput.getText().equals("")) {
      summaryInput.sendKeys(summary);
    }
  }

  private void setPriorityInput(Priority priority) {
    wait.until(ExpectedConditions.elementToBeClickable(projectTypeInput));
    projectTypeInput.clear();

    if (projectTypeInput.getText().equals("")) {
      priorityInput.sendKeys(priority.toString());
    }
  }

  public void createIssue(ProjectType projectType, IssueType issueType, String summary, Priority priority, boolean isAssignToMe) {
    setProjectTypeInput(projectType);
    setIssueTypeInput(issueType);
    setSummaryInput(summary);
    setPriorityInput(priority);

    if (isAssignToMe) {
      assignToMeBtn.click();
    }

    submitBtn.click();
  }

  public boolean isIssueCreatedMsgVisible(WebDriver driver) {
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(popUpWindowMsgXpath)));
    return driver.findElement(By.xpath(popUpWindowMsgXpath)).isDisplayed();
  }

  public void getNewIssuePage() {
    if (isIssueCreatedMsgVisible(driver)) {
      driver.findElement(By.xpath(popUpWindowMsgXpath)).click();
    }
  }
}
