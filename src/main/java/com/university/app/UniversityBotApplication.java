/**
 * The main class of the University Bot application.
 * This class serves as the entry point of the application
 * and implements the CommandLineRunner interface
 * to execute the bot functionality upon application startup.
 * The application uses the Spring Boot framework for configuration and initialization.
 *
 * @author Elvira Solnyshkina
 * @see com.university.app.console.ConsoleUI
 * @see com.university.app.config.DataInitializer
 */

package com.university.app;

import com.university.app.config.DataInitializer;
import com.university.app.console.ConsoleUI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversityBotApplication implements CommandLineRunner {
    private final ConsoleUI consoleUI;
    private final DataInitializer initializer;

    public UniversityBotApplication(ConsoleUI consoleUI, DataInitializer initializer) {
        this.consoleUI = consoleUI;
        this.initializer = initializer;
    }

    public static void main(String[] args) {
        SpringApplication.run(UniversityBotApplication.class, args);
    }

    @Override
    public void run(String... args) {
        initializer.inject();
        consoleUI.start();
    }
}
