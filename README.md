# Selenium Test Application

A complete Java application with Selenium WebDriver tests for automated web testing. This project includes a sample web application and comprehensive test suite.

## Project Structure

```
.
├── pom.xml                                    # Maven configuration
├── README.md                                  # Project documentation
├── src/
│   ├── main/
│   │   └── resources/
│   │       └── webapp/
│   │           ├── index.html                 # Sample web application
│   │           ├── styles.css                 # Styling
│   │           └── script.js                  # JavaScript functionality
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── selenium/
│                       ├── config/
│                       │   └── WebDriverConfig.java  # WebDriver setup
│                       └── tests/
│                           ├── FormTest.java          # Form interaction tests
│                           ├── InteractiveElementsTest.java  # Interactive element tests
│                           ├── DropdownTest.java      # Dropdown selection tests
│                           ├── TableTest.java         # Table data tests
│                           └── PageTitleTest.java     # Basic page tests
```

## Prerequisites

- **Java 11 or higher** - Required for compilation
- **Maven 3.6+** - For dependency management and build
- **Google Chrome** - Default browser for tests (can be configured for Firefox or Edge)

## Setup Instructions

1. **Clone or download the project**

   ```bash
   cd workspace
   ```

2. **Verify Java installation**

   ```bash
   java -version
   ```

   Should display Java 11 or higher.

3. **Verify Maven installation**

   ```bash
   mvn -version
   ```

4. **Download dependencies**
   ```bash
   mvn clean install
   ```
   This will download all required dependencies including Selenium WebDriver and WebDriverManager.

## Running Tests

### Run All Tests

```bash
mvn test
```

### Run Specific Test Class

```bash
mvn test -Dtest=FormTest
mvn test -Dtest=DropdownTest
mvn test -Dtest=TableTest
```

### Run Tests with Different Browsers

Edit `WebDriverConfig.java` to use different browsers:

- Chrome (default): `createChromeDriver()`
- Firefox: `createFirefoxDriver()`
- Edge: `createEdgeDriver()`

## Test Coverage

The test suite includes:

1. **FormTest** - Tests user registration form:

   - Form submission with valid data
   - Required field validation
   - Terms and conditions checkbox requirement

2. **InteractiveElementsTest** - Tests interactive elements:

   - Button click counter
   - Hide/show element functionality

3. **DropdownTest** - Tests dropdown selections:

   - Country selection from dropdown
   - Verification of all available options

4. **TableTest** - Tests data table:

   - Table headers verification
   - Table data rows verification
   - Row count validation

5. **PageTitleTest** - Basic page tests:
   - Page title verification
   - Header text verification

## Dependencies

- **Selenium WebDriver 4.15.0** - Browser automation framework
- **WebDriverManager 5.6.2** - Automatic driver management (no need to manually download drivers)
- **JUnit 5.10.0** - Testing framework
- **AssertJ 3.24.2** - Fluent assertions for better test readability

## Features

- ✅ Automatic browser driver management (no manual driver downloads needed)
- ✅ Multiple browser support (Chrome, Firefox, Edge)
- ✅ Comprehensive test examples covering various web elements
- ✅ Modern testing practices with JUnit 5
- ✅ Fluent assertions with AssertJ
- ✅ Sample web application included for testing

## Sample Web Application

The included web application (`index.html`) features:

- User registration form with validation
- Interactive buttons and elements
- Dropdown selection
- Data table
- Modern, responsive UI

To view the application, open `src/main/resources/webapp/index.html` in your browser.

## Troubleshooting

### Browser Driver Issues

WebDriverManager should automatically download and manage drivers. If you encounter issues:

1. Ensure you have internet connectivity
2. Check firewall settings
3. Manually download drivers if needed (ChromeDriver, GeckoDriver, EdgeDriver)

### Test Failures

- Ensure the web application files are in the correct location
- Check that all required elements exist in the HTML
- Verify browser version compatibility

### Maven Build Issues

```bash
# Clean and rebuild
mvn clean install

# Skip tests during build
mvn clean install -DskipTests
```

## Additional Notes

- Tests use implicit waits for better stability
- Tests are designed to be independent and can run in any order
- The WebDriver is properly closed after each test
- The base URL is automatically constructed from the project path

## Next Steps

- Add more test scenarios as needed
- Integrate with CI/CD pipelines
- Add screenshot capture on test failures
- Implement Page Object Model pattern for better code organization
- Add test reporting (e.g., Allure, ExtentReports)

## License

This is a sample project for educational purposes.

