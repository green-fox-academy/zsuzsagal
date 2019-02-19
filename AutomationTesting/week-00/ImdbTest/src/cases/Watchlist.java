package cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Watchlist {
//  adding
//  listing
//  editing
//  ordering
//  custom lists

  public static void getWatchlist(WebDriver webdriver) {
//    OpenHomePage.imdbOpen();
    WebElement signInBtn = webdriver.findElement(By.id("imdb-signin-link"));
    signInBtn.click();


  }

}
