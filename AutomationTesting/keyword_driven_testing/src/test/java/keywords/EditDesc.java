package keywords;

import dataProvider.SystemDefaults;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditDesc {

  private static WebDriverWait wait;

  public static void replaceExistingDesc(WebDriver webDriver, SystemDefaults defaults, String descText) {
    wait = new WebDriverWait(webDriver, defaults.getWaitTimeOut());
    WebElement desc = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("description-val")));
    desc.click();
    WebElement descTextArea = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[id=description]")));
    descTextArea.click();
    descTextArea.clear();
    descTextArea.sendKeys(descText);
    descTextArea.sendKeys(Keys.ENTER);
    WebElement descDiv = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("descriptionmodule_heading")));
    descDiv.click();
    webDriver.navigate().refresh();
  }

  public static void addTextToDesc(WebDriver webDriver, SystemDefaults defaults, String descText) {
    wait = new WebDriverWait(webDriver, defaults.getWaitTimeOut());
    WebElement desc = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("description-val")));
    desc.click();
    WebElement descTextArea = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[id=description]")));
    String currentText = descTextArea.getText();
    descTextArea.click();
    descTextArea.clear();
    descTextArea.sendKeys(currentText + " " + descText);
    descTextArea.sendKeys(Keys.ENTER);
    WebElement descDiv = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("descriptionmodule_heading")));
    descDiv.click();
    webDriver.navigate().refresh();
  }

  public static boolean isAlertPresent(WebDriver webDriver) {
    boolean presentFlag = false;
    try {
      Alert alert = webDriver.switchTo().alert();
      presentFlag = true;
      alert.accept();
    } catch (NoAlertPresentException ex) {
      ex.printStackTrace();
    }
    return presentFlag;
  }
}
