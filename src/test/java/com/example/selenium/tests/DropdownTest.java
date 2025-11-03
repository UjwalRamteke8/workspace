package com.example.selenium.tests;

import com.example.selenium.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for dropdown selections
 */
public class DropdownTest {

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
  @DisplayName("Should select country from dropdown and display selection")
  void testCountrySelection() {
    WebElement countrySelect = driver.findElement(By.id("countrySelect"));
    Select select = new Select(countrySelect);

    // Verify initial state
    WebElement selectedCountry = driver.findElement(By.id("selectedCountry"));
    assertThat(selectedCountry.getText()).isEmpty();

    // Select United States
    select.selectByValue("usa");
    wait.withTimeout(Duration.ofSeconds(1));
    assertThat(selectedCountry.getText()).contains("United States");

    // Select United Kingdom
    select.selectByValue("uk");
    wait.withTimeout(Duration.ofSeconds(1));
    assertThat(selectedCountry.getText()).contains("United Kingdom");

    // Select Canada
    select.selectByVisibleText("Canada");
    wait.withTimeout(Duration.ofSeconds(1));
    assertThat(selectedCountry.getText()).contains("Canada");
  }

  @Test
  @DisplayName("Should verify all dropdown options are available")
  void testDropdownOptions() {
    WebElement countrySelect = driver.findElement(By.id("countrySelect"));
    Select select = new Select(countrySelect);

    // Verify all options are present
    assertThat(select.getOptions().size()).isEqualTo(5); // 1 default + 4 countries
    assertThat(select.getOptions().get(1).getText()).isEqualTo("United States");
    assertThat(select.getOptions().get(2).getText()).isEqualTo("United Kingdom");
    assertThat(select.getOptions().get(3).getText()).isEqualTo("Canada");
    assertThat(select.getOptions().get(4).getText()).isEqualTo("Australia");
  }
}

