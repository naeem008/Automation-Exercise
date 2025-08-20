Hey there! 👋 Welcome to my automation project. I built this framework to test **[automationexercise.com](https://automationexercise.com/)**, a popular practice website for QA engineers. This wasn't just about making scripts run; it was about building a smart, reusable, and easy-to-maintain testing solution from the ground up.

## 🚀 What Does This Framework Do?

Imagine you need to test if a new user can sign up, log in, and then delete their account. This framework does exactly that, completely on its own.

Here’s the story it automates:
1.  **A New User Arrives:** It starts by creating a brand-new user account with fresh, random data.
2.  **It Takes Notes:** Once the user is created, the framework smartly saves their login details (username, email, password) into an Excel sheet. This is my approach to data-driven testing.
3.  **The User Returns:** In a separate test, it reads those details from the Excel file and logs the user back in.
4.  **Verification is Key:** It then checks the screen to make sure the right user is logged in by finding the "Logged in as..." message.
5.  **Cleaning Up:** Finally, to keep things tidy, it deletes the account it just created.

## 🛠️ My Tech Toolbox

I chose a stack that's both powerful and widely used in the industry. Here’s what’s under the hood:

- **Core Language:** **Java** – because it's robust and platform-independent.
- **The Driver:** **Selenium WebDriver** – the go-to tool for browser automation.
- **The Organizer:** **TestNG** – my framework of choice for managing tests, running them in a specific order, and creating clear assertions.
- **The Architect:** **Page Object Model (POM)** – I used this design pattern to keep the code clean, readable, and easy to update. No more messy scripts!
- **The Brains for Data:** **Apache POI** – this library was my solution for reading from and writing to Excel files, making my tests data-driven.
- **The Narrator:** **Log4j2** – for creating detailed logs. When a test fails, the logs tell the full story of what went wrong and where.
- **The Realistic Data:** **JavaFaker** – to generate believable, random user data for every test run.

## ⚙️ Want to See it in Action?

It’s easy to get this running on your own machine.

### You'll Need:
- Java (JDK 11 or newer)
- Apache Maven
- Your favorite IDE (I used Eclipse/IntelliJ)

### Let's Go:
1.  **Clone the repo:**
    ```bash
    git clone https://github.com/your-username/your-repository-name.git
    ```
2.  **Open it up:** Import the project into your IDE as a Maven project. It'll handle all the dependencies for you.
3.  **Hit Play:** Find the `testng.xml` file, right-click it, and choose **Run As > TestNG Suite**.

That's it! You'll see the browser pop up and the tests run one by one. Check out the IDE console to see my logs narrating the process.

## ✨ What I Learned on This Journey

Building this wasn't just about writing code. It was a great learning experience where I got to practice:

-   **Thinking Like an Architect:** Structuring the project with the Page Object Model taught me how to write code that's built to last.
-   **Solving Real Problems:** When a simple click didn't work on a dynamic element, I dug deeper and used **JavaScript Executor** to get the job done—a great tool to have in my back pocket.
-   **Writing Smart Waits:** I moved away from flaky `Thread.sleep()` and embraced **Explicit Waits**, making my tests faster and far more reliable.
-   **Telling a Story with Data:** By integrating Apache POI, I learned how to separate the test logic from the test data, which is key for scaling up testing.

Thanks for checking out my work!