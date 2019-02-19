package keywords;

import dataProvider.SystemDefaults;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubtaskHandling {

  private static WebDriverWait wait;
  private static Actions mouseHover;

  private static WebElement moreDropDown;
  private static WebElement createSubTask;
  private static WebElement subTaskDialog;
  private static WebElement summaryField;
  private static WebElement submitCreateBtn;
  private static WebElement newSubTask;
  private static WebElement subTaskToDelete;
  private static WebElement delBtn;
  private static WebElement subTaskPanel;
  private static WebElement tickBox;

  public static void fillSubTask(WebDriver driver, SystemDefaults defaults, String summary) {
    wait = new WebDriverWait(driver, defaults.getWaitTimeOut());

    moreDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.id("opsbar-operations_more")));
    moreDropDown.click();

    createSubTask = wait.until(ExpectedConditions.elementToBeClickable(By.id("create-subtask")));
    createSubTask.click();
    subTaskDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create-subtask-dialog")));

    summaryField = wait.until(ExpectedConditions.elementToBeClickable(By.id("summary")));
    summaryField.sendKeys(summary);

    tickBox = driver.findElement(By.id("qf-create-another"));
    if (tickBox.isSelected()) {
      tickBox.click();
    }

    submitCreateBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("create-issue-submit")));
    submitCreateBtn.click();
  }

  public static String getNewSubTask(WebDriver driver, SystemDefaults defaults) {
    wait = new WebDriverWait(driver, defaults.getWaitTimeOut());

    subTaskPanel = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("issuetable")));
    mouseHover = new Actions(driver);
    mouseHover.moveToElement(subTaskPanel).perform();
    newSubTask = wait.until(ExpectedConditions.presenceOfElementLocated(
        By.xpath("//*[@id=\"view-subtasks\"]//a[contains(@class, 'issue-link')]")));
    return newSubTask.getText();
  }

  public static void deleteSubTask(WebDriver driver, SystemDefaults defaults) {
    wait = new WebDriverWait(driver, defaults.getWaitTimeOut());

    subTaskPanel = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("issuetable")));
    mouseHover = new Actions(driver);
    mouseHover.moveToElement(subTaskPanel).perform();
    moreDropDown = wait.until(ExpectedConditions.presenceOfElementLocated(
        By.xpath("//*[@id=\"view-subtasks\"]//a[contains(@class, 'actions')]")));
    moreDropDown.click();

    subTaskToDelete = wait.until(ExpectedConditions.presenceOfElementLocated(
        By.xpath("//*[@id=\"AJS_DROPDOWN_LISTITEM__72\"]")));
    subTaskToDelete.click();
    delBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("delete-issue-submit")));
    delBtn.click();
  }
}
