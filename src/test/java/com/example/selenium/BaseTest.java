package com.example.selenium;

import com.example.selenium.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Base test class with common setup and teardown methods
 * Other test classes can extend this for shared functionality
 */
public abstract class BaseTest {

  protected WebDriver driver;
  protected WebDriverWait wait;

  @BeforeEach
  void setUp() {
    driver = WebDriverConfig.createChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.get(WebDriverConfig.getBaseUrl());
  }

  @AfterEach
  void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
