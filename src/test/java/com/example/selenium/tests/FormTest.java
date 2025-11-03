package com.example.selenium.tests;

import com.example.selenium.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for form interactions
 */
public class FormTest {

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
  @DisplayName("Should successfully submit registration form with valid data")
  void testSubmitRegistrationForm() {
    // Fill in the form
    driver.findElement(By.id("firstName")).sendKeys("John");
    driver.findElement(By.id("lastName")).sendKeys("Doe");
    driver.findElement(By.id("email")).sendKeys("john.doe@example.com");
    driver.findElement(By.id("password")).sendKeys("SecurePassword123");
    driver.findElement(By.id("agreeTerms")).click();

    // Submit the form
    driver.findElement(By.id("submitBtn")).click();

    // Wait for success message
    WebElement message = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.id("message")));

    // Verify success message
    assertThat(message.getText())
        .contains("Registration successful")
        .contains("John Doe");
    assertThat(message.getAttribute("class")).contains("success");
  }

  @Test
  @DisplayName("Should validate required fields")
  void testRequiredFieldsValidation() {
    // Try to submit form without filling required fields
    driver.findElement(By.id("submitBtn")).click();

    // Check that the form doesn't submit (HTML5 validation)
    WebElement firstName = driver.findElement(By.id("firstName"));
    String validationMessage = firstName.getAttribute("validationMessage");
    assertThat(validationMessage).isNotEmpty();
  }

  @Test
  @DisplayName("Should require terms checkbox to be checked")
  void testTermsCheckboxRequired() {
    // Fill form but don't check terms
    driver.findElement(By.id("firstName")).sendKeys("Jane");
    driver.findElement(By.id("lastName")).sendKeys("Smith");
    driver.findElement(By.id("email")).sendKeys("jane@example.com");
    driver.findElement(By.id("password")).sendKeys("Password123");

    // Submit without checking terms
    driver.findElement(By.id("submitBtn")).click();

    // Verify form doesn't submit
    WebElement checkbox = driver.findElement(By.id("agreeTerms"));
    assertThat(checkbox.isSelected()).isFalse();
  }
}

