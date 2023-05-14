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
    public static final String SEPARATOR = "_______________________________________________________";
    public static final String COMMAND_1 = "Type 1: Who is the head of the department.";
    public static final String COMMAND_2 = "Type 2: Show department statistics.";
    public static final String COMMAND_3 = "Type 3: Show the average salary for the department.";
    public static final String COMMAND_4 = "Type 4: Show the count of employees for the department.";
    public static final String COMMAND_5 = "Type 5: Global search.";
    public static final String COMMAND_6 = "Type 6: Exit.";
    public static final String TYPE_SECTION = "Type here: ";
    public static final String INVALID_COMMAND = "Invalid command. Please, type 1-6.";
    public static final String GREETINGS = "Hi! My name is Lucky!" + System.lineSeparator()
            + "I am simple, but pretty amazing info bot." + System.lineSeparator()
            + "Choose your command for getting more information about your university!" + System.lineSeparator();
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
            String menu = SEPARATOR + System.lineSeparator()
                    + COMMAND_1 + System.lineSeparator()
                    + SEPARATOR + System.lineSeparator()
                    + COMMAND_2 + System.lineSeparator()
                    + SEPARATOR + System.lineSeparator()
                    + COMMAND_3 + System.lineSeparator()
                    + SEPARATOR + System.lineSeparator()
                    + COMMAND_4 + System.lineSeparator()
                    + SEPARATOR + System.lineSeparator()
                    + COMMAND_5 + System.lineSeparator()
                    + SEPARATOR + System.lineSeparator()
                    + COMMAND_6 + System.lineSeparator()
                    + SEPARATOR + System.lineSeparator()
                    + TYPE_SECTION;
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
                System.out.println(INVALID_COMMAND);
            }
        }
    }
    public void sayHello() {
        System.out.println(GREETINGS);
    }
}
