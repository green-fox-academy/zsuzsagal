package keywords;

import dataProvider.SystemDefaults;
import enums.LinkType;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IssueLinking {
  private static WebDriverWait wait;
  private static Actions mouseHover;

  private static WebElement moreDropDown;
  private static WebElement linkBtn;
  private static WebElement linkDialogWindow;
  private static WebElement selectTypeDropDown;
  private static WebElement selectIssueField;
  private static WebElement submitLink;
  private static WebElement linkContent;
  private static WebElement linkedIssue;
  private static WebElement deleteLink;
  private static WebElement deleteBtn;

  public static void linkIssue(WebDriver driver, SystemDefaults defaults, LinkType linkType, String linkToIssue) {
    wait = new WebDriverWait(driver, defaults.getWaitTimeOut());

    moreDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.id("opsbar-operations_more")));
    moreDropDown.click();

    linkBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("link-issue")));
    linkBtn.click();

    linkDialogWindow = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("link-issue-dialog")));
    selectTypeDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.id("link-type")));
    selectTypeDropDown.sendKeys(linkType.toString(), Keys.ENTER);

    selectIssueField = wait.until(ExpectedConditions.elementToBeClickable(By.id("jira-issue-keys-textarea")));
    selectIssueField.sendKeys(linkToIssue);

    submitLink = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//*[@id=\"link-jira-issue\"]/div[2]/div/input")));
    submitLink.click();
  }

  public static String getLinkedIssue(WebDriver driver, SystemDefaults defaults) {
    wait = new WebDriverWait(driver, defaults.getWaitTimeOut());

    linkContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("link-content")));
    mouseHover = new Actions(driver);
    mouseHover.moveToElement(linkContent).perform();
    linkedIssue = wait.until(ExpectedConditions.presenceOfElementLocated(
        By.xpath("//*[@class=\"links-container\"]//a[contains(@class, 'issue-link')]")));
    return linkedIssue.getText();
  }

  public static void deleteLinkedIssue(WebDriver driver, SystemDefaults defaults, String linkToIssue) {
    wait = new WebDriverWait(driver, defaults.getWaitTimeOut());

    linkContent = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("link-content")));
    mouseHover = new Actions(driver);
    mouseHover.moveToElement(linkContent).perform();

    linkedIssue = driver.findElement(
        By.xpath("//*[@class=\"links-container\"]//span[contains(@title, '" + linkToIssue + "')]"));
    deleteLink = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//*[@class=\"links-container\"]//a[contains(@id, 'delete-link')]")));
    mouseHover.moveToElement(deleteLink).perform();
    deleteLink.click();

    deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("issue-link-delete-submit")));
    deleteBtn.click();
  }

  public static boolean isExistLinkContent(WebDriver driver, SystemDefaults defaults) {
    wait = new WebDriverWait(driver, defaults.getWaitTimeOut());
    boolean isExist = false;

    if (driver.findElements(By.className("link-content")).isEmpty()) {
      isExist = true;
    }
    return isExist;
  }
}
