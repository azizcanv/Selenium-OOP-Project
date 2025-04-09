# Selenium OOP Automation Project

This project is an automation test framework designed to interact with the Beymen website. It is built using Java and Selenium, following a modular and scalable structure.

---

## Features

- **Modular Design**: Clear separation of concerns for better maintainability.
- **Reusable Components**: Page Object Model (POM) structure.
- **Data-Driven Testing**: Uses Excel for search terms.

---

## Project Structure

```
selenium-oop-project/
├── .idea/                      # IDE configuration files
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── driver/         # WebDriver setup and configuration
│   │   │   │   └── Driver.java
│   │   │   ├── pages/          # Page Object Model classes
│   │   │   │   ├── CartPage.java
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── ProductPage.java
│   │   │   │   └── SearchPage.java
│   │   │   ├── utils/          # Utility classes
│   │   │   │   ├── ExcelUtil.java
│   │   │   │   └── FileUtil.java
│   │   └── resources/          # External resources
│   │       └── searchTerms.xlsx
│   └── test/
│       ├── java/
│       │   └── tests/          # Test cases
│       │       └── BeymenAutomationTest.java
├── .gitignore                  # Files and directories to be ignored by Git
├── pom.xml                     # Maven configuration file
├── productDetails.txt          # Sample product details
└── README.md                   # Documentation of the project
```

---

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/azizcanv/Selenium-OOP-Project.git
   cd selenium-oop-project
   ```

2. **Open the project in an IDE**:
    - Use IntelliJ IDEA or any other Java-compatible IDE.

3. **Setup dependencies**:
    - Ensure Maven is properly configured to download dependencies from the `pom.xml` file.

---

## Usage

1. **Update search terms**:
    - Edit `src/main/resources/searchTerms.xlsx` with the desired search keywords.

2. **Run Tests**:
    - Execute the test cases in `BeymenAutomationTest.java`.
    - Use your IDE's test runner or the Maven command:
      ```bash
      mvn test
      ```

---

## Contact

- **Author**: Aziz Can Varol
- **GitHub**: [azizcanv](https://github.com/azizcanv)
- **Email**: [azizcanv@gmail.com](mailto:azizcanv@gmail.com)
