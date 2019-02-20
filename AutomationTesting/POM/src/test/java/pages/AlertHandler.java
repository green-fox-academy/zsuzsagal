package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertHandler {
  public static boolean isAlertPresent(WebDriver webDriver) {
    boolean presentFlag = false;
    try {
      Alert alert = webDriver.switchTo().alert();
      presentFlag = true;
      alert.accept();
    } catch (NoAlertPresentException ex) {
    }
    return presentFlag;
  }
}
