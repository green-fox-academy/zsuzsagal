package cases;

import org.openqa.selenium.WebDriver;

public class OpenHomePage {

  public static void imdbOpen(WebDriver webdriver, String url){
    webdriver.get(url);
  }

}