# IsharaText-Testing

Automated testing framework for the Indian Sign Language (ISL) Buddy web application.

## Tech Stack
- Selenium WebDriver 4.31.0
- TestNG 7.11.0
- Java 24
- Maven 3.9.x

## Quick Start

### Prerequisites
- JDK 24
- Maven 3.9.x
- Chrome/Firefox/Edge browsers

### Setup
1. Clone and install:
```bash
git clone [repository-url]
mvn clean install
```

2. Run tests:
```bash
mvn test
```

## IDE Setup

### Eclipse
1. Install TestNG plugin
2. Import as Maven project
3. Right-click `testng.xml` → Run As → TestNG Suite

### VS Code
1. Install Java Extension Pack
2. Open folder
3. Run using Test Explorer

## Project Structure
```
src/
├── main/java/Pages/     # Page Objects
├── test/java/           # Test Cases
└── test/resources/      # Test Data
```

## Test Categories
- Smoke Tests
- Regression Tests
- Cross-browser Tests

## License
This project is in the public domain.
