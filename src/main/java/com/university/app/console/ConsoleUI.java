package com.university.app.console;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.university.app.commands.Command;
import com.university.app.commands.impl.AverageSalaryCommand;
import com.university.app.commands.impl.DepartmentStatisticsCommand;
import com.university.app.commands.impl.EmployeeCountCommand;
import com.university.app.commands.impl.ExitCommand;
import com.university.app.commands.impl.GlobalSearchCommand;
import com.university.app.commands.impl.HeadOfDepartmentCommand;
import com.university.app.services.DepartmentService;
import org.springframework.stereotype.Component;

@Component
public class ConsoleUI {
    private final Map<String, Command> commands = new HashMap<>();

    public ConsoleUI(DepartmentService departmentService) {
        commands.put("1", new HeadOfDepartmentCommand(departmentService));
        commands.put("2", new DepartmentStatisticsCommand(departmentService));
        commands.put("3", new AverageSalaryCommand(departmentService));
        commands.put("4", new EmployeeCountCommand(departmentService));
        commands.put("5", new GlobalSearchCommand(departmentService));
        commands.put("6", new ExitCommand(departmentService));
    }

    public void start() {
        sayHello();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String menu = "___________________________________________________\n"
                    + "Type 1: Who is the head of the department.\n"
                    + "___________________________________________________\n"
                    + "Type 2: Show department statistics.\n"
                    + "___________________________________________________\n"
                    + "Type 3: Show the average salary for the department.\n"
                    + "___________________________________________________\n"
                    + "Type 4: Show the count of employees for the department.\n"
                    + "___________________________________________________\n"
                    + "Type 5: Global search.\n"
                    + "___________________________________________________\n"
                    + "Type 6: Exit.\n"
                    + "___________________________________________________\n"
                    + "Type here: ";
            System.out.print(menu);
            String commandLine = scanner.nextLine();
            String commandNumber = String.valueOf(commandLine);
            if (commands.containsKey(commandNumber)) {
                Command command = commands.get(commandNumber);
                command.execute();
                if (command.getClass() == ExitCommand.class) {
                    break;
                }
            } else {
                System.out.println("Invalid command");
            }
        }
    }
    public void sayHello() {
        String greetings = "Hi! My name is Lucky!\n"
                + "I am simple, but pretty amazing info bot.\n"
                + "Choose your command for getting more information about your university!\n";
        System.out.print(greetings);
    }
}
