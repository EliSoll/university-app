package com.university.app.commands.impl;

import java.util.Scanner;
import com.university.app.commands.Command;
import com.university.app.services.DepartmentService;

public class EmployeeCountCommand implements Command {
    private final DepartmentService departmentService;

    public EmployeeCountCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void execute() {
        System.out.print("Type your department: ");
        String input = new Scanner(System.in).nextLine();
        System.out.println(departmentService.getEmployeeCount(input));
    }
}
