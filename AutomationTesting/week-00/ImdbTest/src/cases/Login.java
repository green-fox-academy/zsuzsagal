package cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

//  public static void imdbLogin(WebDriver webdriver) {
//    imdbLogin(webdriver, "alma","123");
//  }

//  public static void imdbLoginWithEmptyName (WebDriver webdriver, String name, String password){
//      webdriver.get("https://imdb.com");
//
//      WebElement username = webdriver.findElement(By.id("usernameid"));
//      WebElement pwd = webdriver.findElement(By.id("loginid"));
//      WebElement button = webdriver.findElement(By.id("buttonid"));
//
//
//      username.sendKeys(name);
//      pwd.sendKeys(password);
//      button.click();
//    }
//
//
//    public static String passwordText(){
//    return "zsuzsa";
//    }
//
//}


  public static void imdbLoginWithValidFields(WebDriver webDriver) {
    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("imdb-signin-link")));
    signInBtn.click();
    WebElement createNewAccountBtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("provider-imdb")));
    createNewAccountBtn.click();
    WebElement customerEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_email")));
    customerEmail.sendKeys("emilyb@gmail.com");
    WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_password")));
    password.sendKeys("12AQc987");
    WebElement signInSubmitbtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("signInSubmit")));
    signInSubmitbtn.click();

  }

//  login with empty email
//  login with empty password
//  login with correct email wrong password
//  login with wrong email correct passwr
  //not valid email
  // too long mail or password

}



