package com.example.selenium.tests;

import com.example.selenium.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Basic page navigation and title test
 */
public class PageTitleTest {

  private WebDriver driver;

  @BeforeEach
  void setUp() {
    driver = WebDriverConfig.createChromeDriver();
  }

  @AfterEach
  void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }

  @Test
  @DisplayName("Should verify page title and URL")
  void testPageTitle() {
    driver.get(WebDriverConfig.getBaseUrl());
    assertThat(driver.getTitle()).isEqualTo("Selenium Test App");
  }

  @Test
  @DisplayName("Should verify page header text")
  void testPageHeader() {
    driver.get(WebDriverConfig.getBaseUrl());
    String headerText = driver.findElement(org.openqa.selenium.By.tagName("h1")).getText();
    assertThat(headerText).isEqualTo("Selenium Test Application");
  }
}

