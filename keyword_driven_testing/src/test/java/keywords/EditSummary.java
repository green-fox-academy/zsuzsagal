package keywords;

import dataProvider.SystemDefaults;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditSummary {

  private static WebDriverWait wait;

  public static void replaceExistingSummary(WebDriver webDriver, SystemDefaults defaults, String summaryText) {
    wait = new WebDriverWait(webDriver, defaults.getWaitTimeOut());
    WebElement summary = wait.until(ExpectedConditions.elementToBeClickable(By.id("summary-val")));
    summary.click();
    WebElement summaryInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("summary")));
    summaryInput.clear();
    summaryInput.sendKeys(summaryText);
    summaryInput.sendKeys(Keys.ENTER);
  }

  public static void addTextToSummary(WebDriver webDriver, SystemDefaults defaults, String summaryText) {
    wait = new WebDriverWait(webDriver, defaults.getWaitTimeOut());
    WebElement summary = wait.until(ExpectedConditions.elementToBeClickable(By.id("summary-val")));
    String currentText = summary.getText();
    summary.click();
    WebElement summaryInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("summary")));
    summaryInput.sendKeys(currentText + " " + summaryText);
    summaryInput.sendKeys(Keys.ENTER);
  }

  public static String getErrorMsgForEmptySummary(WebDriver webDriver, SystemDefaults defaults) {
    wait = new WebDriverWait(webDriver, defaults.getWaitTimeOut());
    WebElement errorMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[data-field='summary']")));
    return errorMsg.getText();
  }

  public static void replaceExistingSummaryUsingEditIcon(WebDriver webDriver, SystemDefaults defaults, String summaryText) {
    wait = new WebDriverWait(webDriver, defaults.getWaitTimeOut());
    Actions action = new Actions(webDriver);
    WebElement summary = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("summary-val")));
    action.moveToElement(summary);
    WebElement editIcon = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='summary-val']/span")));
    action.moveToElement(editIcon).click().build().perform();
    WebElement summaryInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("summary")));
    summaryInput.clear();
    summaryInput.sendKeys(summaryText);
    summaryInput.sendKeys(Keys.ENTER);
  }
}
