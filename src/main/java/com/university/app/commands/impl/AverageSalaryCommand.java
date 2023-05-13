package com.university.app.commands.impl;

import java.util.Scanner;
import com.university.app.commands.Command;
import com.university.app.dto.DepartmentStatistics;
import com.university.app.services.DepartmentService;

public class AverageSalaryCommand implements Command {
    private final DepartmentService departmentService;

    public AverageSalaryCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void execute() {
        System.out.print("Type your department: ");
        String input = new Scanner(System.in).nextLine();
        System.out.println(departmentService.getAverageSalary(input));
    }
}
