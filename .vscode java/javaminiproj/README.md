## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Running This Project

This project uses JavaFX 26.0.1 from `lib/javafx-sdk-26.0.1`.

1. Start MySQL and make sure the `school.student_data` table exists.
2. Run `Server` first to start the RMI service on port `1099`.
3. Run `Client` to open the JavaFX student records window.

In VS Code, use the launch configurations:

- `Run RMI Server`
- `Run JavaFX Client`
