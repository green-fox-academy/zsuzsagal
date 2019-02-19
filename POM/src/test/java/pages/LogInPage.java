package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage extends BasicPage {

  @FindBy(id = "login-form-username")
  private WebElement logInUserName;
  @FindBy(id = "login-form-password")
  private WebElement logInPwd;
  @FindBy(id = "login")
  private WebElement logInBtn;
  @FindBy(xpath = "//div[@id='usernameerror']/p")
  private WebElement logInErrorMsg;

  public LogInPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  private void setLogInUserName(String userName) {
    logInUserName.clear();
    if (logInUserName.getText().equals("")) {
      logInUserName.sendKeys(userName);
    }
  }

  private void setLogInPwd(String pwd) {
    logInPwd.clear();
    if (logInPwd.getText().equals("")) {
      logInPwd.sendKeys(pwd);
    }
  }

  public String getLogInErrorMsg() {
    return logInErrorMsg.getText();
  }

  public void logIn(String username, String pwd) {
    setLogInUserName(username);
    setLogInPwd(pwd);
    logInBtn.click();
  }
}
