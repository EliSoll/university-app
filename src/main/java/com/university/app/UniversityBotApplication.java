package com.university.app;

import java.util.Arrays;
import java.util.List;
import com.university.app.config.DataInitializer;
import com.university.app.console.ConsoleUI;
import com.university.app.models.AcademicDegree;
import com.university.app.models.Department;
import com.university.app.models.Lecturer;
import com.university.app.services.DepartmentService;
import com.university.app.services.LecturerService;
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
