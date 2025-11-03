package com.example.selenium.tests;

import com.example.selenium.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for interactive elements
 */
public class InteractiveElementsTest {

  private WebDriver driver;
  private WebDriverWait wait;

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

  @Test
  @DisplayName("Should increment click counter on button click")
  void testClickCounter() {
    WebElement clickButton = driver.findElement(By.id("clickMe"));
    WebElement clickCount = driver.findElement(By.id("clickCount"));

    // Verify initial state
    assertThat(clickCount.getText()).contains("Click count: 0");

    // Click the button multiple times
    clickButton.click();
    wait.withTimeout(Duration.ofSeconds(2));
    assertThat(clickCount.getText()).contains("Click count: 1");

    clickButton.click();
    wait.withTimeout(Duration.ofSeconds(2));
    assertThat(clickCount.getText()).contains("Click count: 2");
  }

  @Test
  @DisplayName("Should hide and show element when toggle button is clicked")
  void testHideShowElement() {
    WebElement toggleButton = driver.findElement(By.id("hideShow"));
    WebElement hiddenDiv = driver.findElement(By.id("hiddenDiv"));

    // Verify element is initially visible
    assertThat(hiddenDiv.isDisplayed()).isTrue();

    // Click to hide
    toggleButton.click();
    wait.withTimeout(Duration.ofSeconds(1));
    assertThat(hiddenDiv.isDisplayed()).isFalse();
    assertThat(toggleButton.getText()).contains("Show");

    // Click to show
    toggleButton.click();
    wait.withTimeout(Duration.ofSeconds(1));
    assertThat(hiddenDiv.isDisplayed()).isTrue();
    assertThat(toggleButton.getText()).contains("Hide");
  }
}

