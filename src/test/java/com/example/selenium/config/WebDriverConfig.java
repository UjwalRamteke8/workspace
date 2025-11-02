package com.example.selenium.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

/**
 * Configuration class for WebDriver setup
 */
public class WebDriverConfig {

  private static final String BASE_URL = "file:///" + System.getProperty("user.dir")
      .replace("\\", "/") + "/src/main/resources/webapp/index.html";

  public static WebDriver createChromeDriver() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    options.addArguments("--disable-notifications");
    WebDriver driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    return driver;
  }

  public static WebDriver createFirefoxDriver() {
    WebDriverManager.firefoxdriver().setup();
    FirefoxOptions options = new FirefoxOptions();
    WebDriver driver = new FirefoxDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    return driver;
  }

  public static WebDriver createEdgeDriver() {
    WebDriverManager.edgedriver().setup();
    EdgeOptions options = new EdgeOptions();
    options.addArguments("--start-maximized");
    WebDriver driver = new EdgeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    return driver;
  }

  public static String getBaseUrl() {
    return BASE_URL;
  }
}
