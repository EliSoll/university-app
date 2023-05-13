package com.university.app;

import com.university.app.console.ConsoleUI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversityBotApplication implements CommandLineRunner {
    private final ConsoleUI consoleUI;

    public UniversityBotApplication(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }


    public static void main(String[] args) {
        SpringApplication.run(UniversityBotApplication.class, args);
    }

    @Override
    public void run(String... args) {
       consoleUI.start();
    }
}