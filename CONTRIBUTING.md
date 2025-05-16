# Contribution Guidelines to PolishPro
This document outlines the steps, coding standards, and best practices contributors must follow to effectively collaborate on the PolishPro Nail Salon Booking System.

---

## 🛠️ Project Setup

### Prerequisites

- Java 17 or higher  
- Maven 3.8+  
- Git  
- IDE (e.g., IntelliJ IDEA, Eclipse)

### Installation

1. **Fork the Repository**  
   Click the "Fork" button at the top-right of this page.

2. **Clone Your Fork**  
   ```bash
   git clone https://github.com/<your-username>/PolishPro.git
   cd PolishPro
   ```

3. **Build the Project**  
   ```bash
   mvn clean install
   ```

4. **Run the Application Locally**  
   ```bash
   mvn spring-boot:run
   ```
   The app will be available at: `http://localhost:8080`

---

## ✨ Coding Standards

- Use meaningful commit messages (e.g., `fix: prevent double booking issue`)  
- Follow Java and Spring Boot best practices  
- Comment complex logic  
- Keep code organized (Controller, Service, Repository)  
- Add unit tests for new features  
- Ensure all tests pass locally before pushing

---

## ✅ Running Tests

To run unit tests locally:

```bash
mvn test
```

Make sure tests pass before opening a PR.

---

## 🚀 How to Contribute

1. **Fork this Repository**  
   Click the **Fork** button at the top right of the [PolishPro repository](https://github.com/demifarquhar01/PolishPro) to create your own copy.

2. **Clone your Fork**  
   Open your terminal and run:
   ```bash
   git clone https://github.com/your-username/PolishPro.git
   cd PolishPro
   ```

3. **Create a New Branch**  
   Use a descriptive name for your branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```

4. **Make Your Changes and Commit**  
   Ensure your commit message clearly aligns with a related issue:
   ```bash
   git commit -m "feat: add [feature or fix] - relates to #issue-number"
   ```

5. **Push to Your Fork**  
   ```bash
   git push origin feature/your-feature-name
   ```

6. **Open a Pull Request to the `main` Branch**  
   - Include a **clear title and description**
   - Reference the related issue (e.g., `Closes #12`)
   - PRs will be reviewed and discussed before being merged

---

## 🚀 Contribution Process

1. **Pick an Issue**  
   - Go to the [Issues](https://github.com/demifarquhar01/PolishPro/issues) tab  
   - Choose one labeled `good first issue` or `feature-request`

2. **Fork the Repository and Create a Branch**  
   ```bash
   git checkout -b feature/your-feature-name
   ```

3. **Implement Your Changes**  
   - Follow the [Coding Standards](#-coding-standards)  
   - Add or update unit tests if necessary

4. **Commit with Issue Alignment**  
   - Your commit message **must** reference the issue you're working on  
   - Example:
     ```bash
     git commit -m "fix: correct scheduling bug - closes #22"
     ```

5. **Push and Submit a Pull Request (PR)**  
   - Push your branch:
     ```bash
     git push origin feature/your-feature-name
     ```
   - Open a PR with:
     - A **short summary**
     - A **link to the issue**

---
# Issue Labels for Contributors

To help contributors get started easily and understand the project roadmap, we have labeled issues as follows:

---

# Good First Issues for PolishPro

Below are several beginner-friendly issues that can help you get started with contributing to PolishPro. These tasks are simple in scope and are ideal for new contributors. If you decide to work on one, please comment on the issue before starting.

---

### 1. Fix Typos in README.md
**Description:**  
Review the README.md file and correct any spelling or grammatical errors to improve clarity and professionalism.

**Why This is a Good First Issue:**  
- It involves minimal changes.  
- It helps improve project documentation.  
- It familiarizes you with the repository structure.

**Label:** `good-first-issue`

---

## 2. Add Unit Tests for the Appointment Class  
**Description:**  
Increase test coverage by writing additional unit tests for the `Appointment` class. Focus on verifying that:  
- The default status is set correctly.  
- Appropriate errors are thrown when `null` values are passed for required fields.

**Why This is a Good First Issue:**  
- It involves writing simple tests using JUnit.  
- It provides insight into the project’s testing framework (Maven/JUnit).

**Label:** `good-first-issue`

---

## 3. Improve JavaDoc Comments in Builder Classes  
**Description:**  
Enhance the documentation of the builder classes by adding JavaDoc comments to public methods and key parts of the code. This makes the codebase easier to understand for new contributors.

**Why This is a Good First Issue:**  
- It helps improve code quality and readability.  
- It requires only documentation edits, no functional code changes.

**Label:** `good-first-issue`

---

## 4. Add a CI Badge to README.md  
**Description:**  
Integrate a GitHub Actions status badge into the README.md to display the current build status (e.g., passing or failing). This helps visitors quickly see the health of the project.

**Why This is a Good First Issue:**  
- It involves a small update to the README.  
- It promotes transparency in the project's CI/CD status.

**Label:** `good-first-issue`

---

## 5. Create a `.gitignore` File  
**Description:**  
Add a `.gitignore` file to the root of the repository to exclude unnecessary files such as compiled class files, IDE configurations, and log files. This keeps the repo clean and focused only on source code.

**Why This is a Good First Issue:**  
- It helps maintain a clean repository.  
- It’s a simple, non-code-breaking task suitable for newcomers.

**Label:** `good-first-issue`

---

Feel free to browse the [issues](https://github.com/demifarquhar01/PolishPro/issues) and leave a comment if you’d like to claim one.

## 🚀 Feature Requests  
These issues describe desired enhancements or bigger features planned for future development:

- [#45 Send out Email notifications](https://github.com/demifarquhar01/PolishPro/issues/45)  
- [#46 Nail technicians view client preferences](https://github.com/demifarquhar01/PolishPro/issues/46)  
- [#49 Implement Reschedules and Cancellations functionality](https://github.com/demifarquhar01/PolishPro/issues/49)


---

## How to Use Labels on GitHub

1. Navigate to the [Issues page](https://github.com/demifarquhar01/PolishPro/issues) of the repository.  
2. Select the issue you want to label.  
3. On the right sidebar, find the **Labels** section.  
4. Click on **Labels** and select the appropriate label (`good-first-issue` or `feature-request`).  
5. The label will be applied immediately to the issue.  

---

