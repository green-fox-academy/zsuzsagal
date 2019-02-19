package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class AdvSearchPage extends BasicPage {

  @FindBy(className = "switcher-item")
  private WebElement advSearchBtn;
  @FindBy(id = "advanced-search")
  private WebElement searchTextArea;
  @FindBy(className = "issue-list")
  private WebElement listOfResults;

  public AdvSearchPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public void setSearchOnAdv() {
    boolean isAdvSearchBtnVisible = driver.findElement((By.className("switcher-item"))).isDisplayed();

    if (isAdvSearchBtnVisible) {
      wait.until(ExpectedConditions.elementToBeClickable(advSearchBtn));
      advSearchBtn.click();
    }
  }

  public void searchByQuery(String query) {
    wait.until(ExpectedConditions.elementToBeClickable(searchTextArea));
    searchTextArea.click();
    searchTextArea.clear();
    searchTextArea.sendKeys(query, Keys.ENTER);
    driver.navigate().refresh();
  }

  public List<WebElement> getListOfResults() {
    wait.until(ExpectedConditions.elementToBeClickable(listOfResults));
    return driver.findElements(By.className("issue-list"));
  }
}
