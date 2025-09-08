# GEMINI Code Assistant Context

This file provides context for the Gemini code assistant to understand the project structure, conventions, and tasks.

## Project Overview

This is a Java educational project, likely for a programming course. It's organized into several sub-projects, each containing source code for different assignments and exercises. The project also includes homework assignments in the `HW` directory and video lectures in the `video` directory.

### Sub-projects:

* **1_project:** Contains introductory Java exercises, covering basic syntax, variables, and control flow.
*   **2_project:** Contains more advanced exercises, including arrays and more complex logic.
*   **Codewars:** Contains solutions to problems from the Codewars platform.

### Technologies:

*   **Language:** Java
*   **Testing:** The `.qodo/testConfig.toml` file suggests the use of JUnit for testing and Mockito for mocking, although no tests are currently present in the project.

## Building and Running

The project appears to be set up for development in the IntelliJ IDEA IDE.

### Building and Running with IntelliJ IDEA:

1.  Open the project in IntelliJ IDEA.
2.  The IDE should automatically recognize the project structure.
3.  To run a specific program, open the corresponding Java file (e.g., `1_project/src/Main.java`) and click the "Run" button or use the `Ctrl+Shift+F10` shortcut.

### Building and Running from the Command Line:

To compile and run a Java file from the command line, you can use the `javac` and `java` commands.

**Example:**

```bash
# Navigate to the source directory
cd 1_project/src

# Compile the Java file
javac Main.java

# Run the compiled class
java Main
```

## Development Conventions

* The code is written in Java.
* Comments are in Russian and describe the tasks for each file.
* The code is organized into simple classes and methods.
* The project follows standard Java naming conventions.
