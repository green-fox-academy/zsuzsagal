package keywords;

import dataProvider.SystemDefaults;
import enums.IssueType;
import enums.ProjectType;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicSearch {
    private static WebDriverWait wait;

    private static WebElement filterDropDown;
    private static WebElement filterType;
    private static WebElement IssueBtn;

        public static void filteredSearch(WebDriver driver, SystemDefaults defaults, String projectFilter, String typeFilter, String statusFilter, String assigneeFilter) {
        wait = new WebDriverWait(driver, defaults.getWaitTimeOut());
        IssueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("find_link")));
        IssueBtn.click();
        IssueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("issues_new_search_link")));
        IssueBtn.click();

        chooseProject(driver, defaults, projectFilter);
        chooseType(driver, defaults, typeFilter);
        chooseStatus(driver, defaults, statusFilter);
        chooseAssignee(driver, defaults, assigneeFilter);
        driver.navigate().refresh();
    }

    public static void chooseProject(WebDriver driver, SystemDefaults defaults, String projectFilter) {
        wait = new WebDriverWait(driver, defaults.getWaitTimeOut());
        filterDropDown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"content\"]/div[1]/div[3]/div/form/div[1]/div[1]/div[1]/div[1]/div/div[1]/ul/li[1]")));
        filterDropDown.click();
        filterType = wait.until(ExpectedConditions.elementToBeClickable(By.id("searcher-pid-input")));
        filterType.clear();
        filterType.sendKeys(projectFilter, Keys.ENTER);
    }


      public static void chooseType(WebDriver driver, SystemDefaults defaults, String filterExpression) {
        wait = new WebDriverWait(driver, defaults.getWaitTimeOut());
        filterDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div[1]/div[3]/div/form/div[1]/div[1]/div[1]/div[1]/div/div[1]/ul/li[2]")));
        filterDropDown.click();
        filterType = wait.until(ExpectedConditions.elementToBeClickable(By.id("searcher-type-input")));
        filterType.clear();
        filterType.sendKeys(filterExpression, Keys.ENTER);
    }

    public static void chooseStatus(WebDriver driver, SystemDefaults defaults, String filterExpression) {
        wait = new WebDriverWait(driver, defaults.getWaitTimeOut());
        filterDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div[1]/div[3]/div/form/div[1]/div[1]/div[1]/div[1]/div/div[1]/ul/li[3]/div")));
        filterDropDown.click();
        filterType = wait.until(ExpectedConditions.elementToBeClickable(By.id("searcher-status-input")));
        filterType.clear();
        filterType.sendKeys(filterExpression, Keys.ENTER);
    }

    public static void chooseAssignee(WebDriver driver, SystemDefaults defaults, String filterExpression) {
        wait = new WebDriverWait(driver, defaults.getWaitTimeOut());
        filterDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div[1]/div[3]/div/form/div[1]/div[1]/div[1]/div[1]/div/div[1]/ul/li[4]")));
        filterDropDown.click();
        filterType = wait.until(ExpectedConditions.elementToBeClickable(By.id("assignee-input")));
        filterType.clear();
        filterType.sendKeys(filterExpression, Keys.ENTER);
    }

    public static int validateSize(WebDriver driver, SystemDefaults defaults) {
        wait = new WebDriverWait(driver, defaults.getWaitTimeOut());
        return driver.findElements(By.cssSelector("div.search-results")).size();
    }
}