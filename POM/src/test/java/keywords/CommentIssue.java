package keywords;

import dataProvider.SystemDefaults;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommentIssue {
  private static WebDriverWait wait;
  private static Actions mouseHover;

  private static WebElement commentBtn;
  private static WebElement textBtn;
  private static WebElement commentTextField;
  private static WebElement currentComment;
  private static WebElement activityPanelBtn;
  private static WebElement deleteIcon;
  private static WebElement commentPanel;
  private static WebElement submitBtn;

  public static void addCommentToTheIssue(WebDriver driver, SystemDefaults defaults, String comment) {
    wait = new WebDriverWait(driver, defaults.getWaitTimeOut());

    commentBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("comment-issue")));
    commentBtn.click();

    textBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("aui-uid-1")));
    textBtn.click();

    commentTextField = wait.until(ExpectedConditions.elementToBeClickable(By.id("comment")));
    commentTextField.sendKeys(comment);
    commentTextField.submit();
  }

  public static String getCurrentComment(WebDriver driver, SystemDefaults defaults) {
    wait = new WebDriverWait(driver, defaults.getWaitTimeOut());
    try {
      driver.switchTo().alert().accept();
    } catch (NoAlertPresentException noe) {
    }
    activityPanelBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("comment-tabpanel")));
    activityPanelBtn.click();

    currentComment = driver.findElement(By.id("issue_actions_container"));
    return currentComment.getText();
  }

  public static void deleteCurrentComment(WebDriver driver, SystemDefaults defaults) {
    wait = new WebDriverWait(driver, defaults.getWaitTimeOut());

    commentPanel = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("issue_actions_container")));
    mouseHover = new Actions(driver);
    mouseHover.moveToElement(commentPanel);
    mouseHover.perform();
    deleteIcon = wait.until(ExpectedConditions.presenceOfElementLocated(
        By.xpath("//*[@id=\"issue_actions_container\"]//a[contains(@id, 'delete_comment')]")));
    deleteIcon.click();

    submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("comment-delete-submit")));
    submitBtn.click();
  }
}
