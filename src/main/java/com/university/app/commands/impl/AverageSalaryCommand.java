/**
 The AverageSalaryCommand class represents a command
 that retrieves and displays the average salary for a department.
 It implements the Command interface.
 @author Elvira Solnyshkina
 */

package com.university.app.commands.impl;

import com.university.app.commands.Command;
import com.university.app.services.DepartmentService;
import java.util.Scanner;

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
