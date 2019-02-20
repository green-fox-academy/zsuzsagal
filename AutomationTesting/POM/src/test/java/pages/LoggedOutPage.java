package pages;

import dataProvider.SystemDefaults;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedOutPage extends BasicPage {
  private String path = "/secure/ViewProfile.jspa";

  @FindBy(xpath = "//*[@id=\"content\"]/div/div/section/div/div/p[1]")
  private WebElement logOutMsg;

  public LoggedOutPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public boolean isLogOutMsgVisible() {
    return logOutMsg.isDisplayed();
  }

  public boolean isUnableToAccessProfileMsgVisible(WebDriver driver, SystemDefaults defaults) {
    driver.navigate().to(defaults.getUrl() + path);
    return driver.findElement(By.xpath("//form[@id='login-form']/div[1]/div[1]/p[1]")).isDisplayed();
  }
}
