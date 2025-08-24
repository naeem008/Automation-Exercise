# Web Automation Framework for AutomationExercise.com

A lightweight but powerful test automation framework built with **Java, Selenium, and TestNG**. This project automates the complete user lifecycle on the [automationexercise.com](https://automationexercise.com/) website: from signing up to deleting the account.

---

### ✅ **Features & Test Flow**

This framework automates the following key user actions:

-   **User Registration:** Creates a new user with random, valid data.
-   **Data Management:** Saves the new user's credentials to an **Excel** file.
-   **User Login:** Reads credentials from Excel and logs the user in.
-   **Verification:** Asserts that the correct user is logged in.
-   **Account Cleanup:** Deletes the user account after the test is complete.

---

### 🛠️ **Tech Stack**

| Technology | Purpose |
| :--- | :--- |
| **Java** | Core Programming Language |
| **Selenium WebDriver**| Browser Automation |
| **TestNG** | Test Runner & Assertion Library |
| **Maven** | Dependency Management |
| **Apache POI** | Excel File Operations (Data-Driven) |
| **Log4j2** | Logging |
| **Page Object Model** | Design Pattern |

---

### 🚀 **Getting Started**

You can run this project on your local machine in just a few steps.

**1. Prerequisites:**
- Java (JDK 11+)
- Maven

**2. Clone the Repository:**
```bash
git clone https://github.com/your-username/your-repository-name.git
```

**3. Run the Tests:**
- Open the project in your favorite IDE (like Eclipse or IntelliJ).
- Right-click on the **`testng.xml`** file and select **Run As > TestNG Suite**.

---

### ✨ **Key Technical Highlights**

This project demonstrates several industry best practices:

-   **Page Object Model (POM):** For clean, maintainable, and reusable code.
-   **Data-Driven Testing:** User credentials are managed externally in an Excel file using Apache POI.
-   **Smart Synchronization:** The framework relies on **Explicit Waits**, completely avoiding flaky `Thread.sleep()`.
-   **Advanced Problem Solving:** Used **JavaScript Executor** to interact with a dynamic web element that was unresponsive to standard Selenium commands.

Thanks for visiting!