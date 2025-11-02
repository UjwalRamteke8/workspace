package com.example.selenium.tests;

import com.example.selenium.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for table interactions
 */
public class TableTest {

  private WebDriver driver;

  @BeforeEach
  void setUp() {
    driver = WebDriverConfig.createChromeDriver();
    driver.get(WebDriverConfig.getBaseUrl());
  }

  @AfterEach
  void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }

  @Test
  @DisplayName("Should verify table headers are present")
  void testTableHeaders() {
    WebElement table = driver.findElement(By.id("dataTable"));

    // Verify headers
    assertThat(table.findElement(By.xpath(".//th[1]")).getText()).isEqualTo("ID");
    assertThat(table.findElement(By.xpath(".//th[2]")).getText()).isEqualTo("Name");
    assertThat(table.findElement(By.xpath(".//th[3]")).getText()).isEqualTo("Email");
    assertThat(table.findElement(By.xpath(".//th[4]")).getText()).isEqualTo("Status");
  }

  @Test
  @DisplayName("Should verify table data rows")
  void testTableDataRows() {
    WebElement table = driver.findElement(By.id("dataTable"));

    // Verify first row
    assertThat(table.findElement(By.xpath(".//tbody/tr[1]/td[1]")).getText()).isEqualTo("1");
    assertThat(table.findElement(By.xpath(".//tbody/tr[1]/td[2]")).getText()).isEqualTo("John Doe");
    assertThat(table.findElement(By.xpath(".//tbody/tr[1]/td[3]")).getText()).isEqualTo("john@example.com");
    assertThat(table.findElement(By.xpath(".//tbody/tr[1]/td[4]")).getText()).isEqualTo("Active");

    // Verify second row
    assertThat(table.findElement(By.xpath(".//tbody/tr[2]/td[2]")).getText()).isEqualTo("Jane Smith");

    // Verify third row
    assertThat(table.findElement(By.xpath(".//tbody/tr[3]/td[2]")).getText()).isEqualTo("Bob Johnson");
    assertThat(table.findElement(By.xpath(".//tbody/tr[3]/td[4]")).getText()).isEqualTo("Inactive");
  }

  @Test
  @DisplayName("Should verify total number of rows in table")
  void testTableRowCount() {
    WebElement table = driver.findElement(By.id("dataTable"));
    int rowCount = table.findElements(By.xpath(".//tbody/tr")).size();
    assertThat(rowCount).isEqualTo(3);
  }
}
