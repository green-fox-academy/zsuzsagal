package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectVersionPage extends BasicPage {

  @FindBy(xpath = "//td[@class='versions-table__name']")
  private WebElement versionNameGlass;
  @FindBy(xpath = "//td[@class='versions-table__date_start']")
  private WebElement versionStartDateGlass;
  @FindBy(xpath = "//td[@class='versions-table__date_release']")
  private WebElement versionReleaseDateGlass;
  @FindBy(xpath = "//td[@class='versions-table__description']")
  private WebElement versionDescGlass;
  @FindBy(id = "administer_project_versions")
  private WebElement projectVersions;
  @FindBy(xpath = "//input[@name='name']")
  private WebElement versionName;
  @FindBy(xpath = "//input[@name='startDate']")
  private WebElement versionStartDate;
  @FindBy(xpath = "//input[@name='releaseDate']")
  private WebElement versionReleaseDate;
  @FindBy(xpath = "//input[@name='description']")
  private WebElement versionDesc;
  @FindBy(className = "releases-add__confirm")
  private WebElement addVersionBtn;
  @FindBy(id = "aui-uid-2")
  private WebElement versionsTab;
  @FindBy(xpath = "//*[@id='versions-table']/tbody[2]/tr/td[8]/div/a")
  private WebElement versionActions;
  @FindBy(xpath = "//a[text()='Edit']")
  private WebElement editOption;
  @FindBy(xpath = "//a[text()='Delete']")
  private WebElement deleteOption;

  public ProjectVersionPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public String getVersionName() {
    if (isElementExist()) {
      return versionNameGlass.getText();
    } else {
      return null;
    }
  }

  public String getVersionStartDate() {
    return versionStartDateGlass.getText();
  }

  public String getVersionReleaseDate() {
    return versionReleaseDateGlass.getText();
  }

  public String getVersionDesc() {
    return versionDescGlass.getText();
  }

  private boolean isElementExist() {
    try {
      wait.until(ExpectedConditions.elementToBeClickable(versionNameGlass));
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  public void createVersion(String versionNameVal, String versionStartDateVal, String versionReleaseDateVal, String versionDescVal) {
    projectVersions.click();
    versionName.sendKeys(versionNameVal);
    versionStartDate.sendKeys(versionStartDateVal);
    versionReleaseDate.sendKeys(versionReleaseDateVal);
    versionDesc.sendKeys(versionDescVal);
    addVersionBtn.click();
    driver.navigate().refresh();
    AlertHandler.isAlertPresent(driver);
  }

  public void clickOnVersionInGlassDoc() {
    Actions action = new Actions(driver);
    action.moveToElement(versionsTab);
    versionsTab.click();
  }

  public void editVersion(String editVersionNameVal, String editVersionStartDateVal, String editVersionReleaseDateVal, String editVersionDescVal) {
    projectVersions.click();
    versionActions.click();
    editOption.click();
    WebElement versionName = wait.until(ExpectedConditions.elementToBeClickable(By.id("version-name")));
    versionName.clear();
    versionName.sendKeys(editVersionNameVal);

    WebElement versionStartDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='userStartDate']")));
    versionStartDate.clear();
    versionStartDate.sendKeys(editVersionStartDateVal);

    WebElement versionReleaseDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='userReleaseDate']")));
    versionReleaseDate.clear();
    versionReleaseDate.sendKeys(editVersionReleaseDateVal);

    WebElement versionDesc = wait.until(ExpectedConditions.elementToBeClickable(By.id("version-description")));
    versionDesc.clear();
    versionDesc.sendKeys(editVersionDescVal);

    WebElement submitEditBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("version-save-submit")));
    submitEditBtn.click();

    driver.navigate().refresh();
    AlertHandler.isAlertPresent(driver);
  }

  public void deleteVersion() {
    projectVersions.click();
    versionActions.click();
    deleteOption.click();
    WebElement yesBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
    yesBtn.click();
    driver.navigate().refresh();
    AlertHandler.isAlertPresent(driver);
  }

}
