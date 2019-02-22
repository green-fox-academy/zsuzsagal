package keywords;

import dataProvider.SystemDefaults;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AtchHandler {

  private static WebDriverWait wait;
  private static String atchFileName;

  public static String getAtchFileName() {
    return atchFileName;
  }

  public static void atchFile(WebDriver webDriver, SystemDefaults defaults) {
    wait = new WebDriverWait(webDriver, defaults.getWaitTimeOut());
    WebElement dropDownArea = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"attachmentmodule\"]/div[2]/div/span/button")));
    dropDownArea.click();
    WebElement atchdFile = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"attachment_thumbnails\"]/li/dl/dt/a")));
    atchFileName = atchdFile.getText();
  }

  public static void deleteAtch(WebDriver webDriver, SystemDefaults defaults) {
    wait = new WebDriverWait(webDriver, defaults.getWaitTimeOut());
    Actions action = new Actions(webDriver);
    WebElement atchdFile1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ol[@id='attachment_thumbnails']/li[1]")));
    action.moveToElement(atchdFile1).build().perform();
    WebElement delIcon = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@class,'aui-iconfont-delete')]")));
    delIcon.click();
    wait.until(ExpectedConditions.elementToBeClickable(By.id("delete-attachment-dialog")));
    WebElement delBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("delete-attachment-submit")));
    delBtn.click();
  }
}
