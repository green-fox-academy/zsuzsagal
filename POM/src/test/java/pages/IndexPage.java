package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage extends BasicPage {

  @FindBy(id = "header-details-user-fullname")
  private WebElement loggedInUserName;
  @FindBy(id = "log_out")
  private WebElement logOutBtn;
  @FindBy(id = "create_link")
  private WebElement createIssueBtn;
  @FindBy(id = "quicksearch")
  private WebElement quickSearch;
  @FindBy(id = "quickSearchInput")
  private WebElement quickSearchInput;
  @FindBy(id = "find_link")
  private WebElement issuesBtn;
  @FindBy(id = "issues_new_search_link_lnk")
  private WebElement searchForIssuesBtn;

  public IndexPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public String getLoggedInUserName() {
    return loggedInUserName.getAttribute("data-username");
  }

  public void logOut() {
    loggedInUserName.click();
    logOutBtn.click();
  }

  public void clickCreateIssueBtn() {
    createIssueBtn.click();
  }

  public void quickSearchByString(String input) {
    quickSearch.click();
    quickSearchInput.clear();
    if (quickSearchInput.getText().equals("")) {
      quickSearchInput.sendKeys(input, Keys.ENTER);
    }
  }

  public void getSearchIssuePage() {
    issuesBtn.click();
    wait.until(ExpectedConditions.elementToBeClickable(searchForIssuesBtn));
    searchForIssuesBtn.click();
  }
}
