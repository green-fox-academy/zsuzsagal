package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SystemDefaults {
  private Properties properties;
  private final String PROPERTY_FILE_PATH = "configs/Configuration.properties";

  public SystemDefaults(){
    try (BufferedReader reader = new BufferedReader(new FileReader(PROPERTY_FILE_PATH))){
      properties = new Properties();
      properties.load(reader);
    } catch (FileNotFoundException e){
        throw new RuntimeException("");
    } catch (IOException e) {
        throw new RuntimeException("");
    } catch (Exception e) {
        throw new RuntimeException("");
    }
  }

  public String getUserName() {
    String userName = properties.getProperty("userName");
    if (userName != null) {
      return userName;
    }
    throw new RuntimeException("Username is not specified in in the Configuration.properties file.");
  }

  public String getPwd() {
    String pwd = properties.getProperty("pwd");
    if (pwd != null) {
      return pwd;
    }
    throw new RuntimeException("Password is not specified in in the Configuration.properties file.");
  }

  public String getUrl() {
    String url = properties.getProperty("url");
    if (url != null) {
      return url;
    }
    throw new RuntimeException("URL is not specified in in the Configuration.properties file.");
  }

  public long getWaitTimeOut() {
    String timeOut = properties.getProperty("WAIT_TIMEOUT");
    if (timeOut != null) {
      return Long.parseLong(timeOut);
    }
    throw new RuntimeException("Timeout is not specified in in the Configuration.properties file.");
  }

  public String getWebDriver() {
    String driver = properties.getProperty("webDriver");
    if (driver != null) {
      return driver;
    }
    throw new RuntimeException("Webdriver is not specified in in the Configuration.properties file.");
  }

  public String getDriverPath() {
    String driver = properties.getProperty("driverPath");
    if (driver != null) {
      return driver;
    }
    throw new RuntimeException("Webdriver Path is not specified in in the Configuration.properties file.");
  }
}
