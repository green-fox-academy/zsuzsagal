package keywords;

import dataProvider.SystemDefaults;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

public class ProfilePicture {

  private static WebDriverWait wait;
  private static WebElement userDropDownMenu;
  private static WebElement viewProfileButton;
  private static WebElement editAvatarButton;
  private static WebElement avatarPickPopUp;
  private static WebElement newAvatar;
  private static WebElement oldAvatar;

  public static void selectNewAvatar(WebDriver driver, SystemDefaults defaults) {
    wait = new WebDriverWait(driver, defaults.getWaitTimeOut());

    avatarPickPopUp = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("jira-avatars")));

    newAvatar = wait.until(ExpectedConditions.elementToBeClickable(By.id("avatar-10122")));
    newAvatar.click();
  }

  public static void revertAvatar(WebDriver driver, SystemDefaults defaults) {
    wait = new WebDriverWait(driver, defaults.getWaitTimeOut());

    avatarPickPopUp = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("jira-avatars")));

    oldAvatar = wait.until(ExpectedConditions.elementToBeClickable(By.id("avatar-10341")));
    oldAvatar.click();
  }

  public static String getAvatar(WebDriver driver, SystemDefaults defaults) {
    wait = new WebDriverWait(driver, defaults.getWaitTimeOut());

    oldAvatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
        ("#details-user-avatar-trigger > img")));

    return oldAvatar.getAttribute("src");
  }

  public static void changeAvatar(WebDriver driver, SystemDefaults defaults){
    wait = new WebDriverWait(driver, defaults.getWaitTimeOut());

    userDropDownMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("header-details-user-fullname")));
    userDropDownMenu.click();

    viewProfileButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("view_profile")));
    viewProfileButton.click();

    editAvatarButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
        ("//*[@id=\"details-user-avatar-trigger\"]/img")));
    editAvatarButton.click();
  }
}
