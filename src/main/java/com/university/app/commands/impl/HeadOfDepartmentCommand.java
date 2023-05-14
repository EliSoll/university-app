/**
 The HeadOfDepartmentCommand class represents a command that
 retrieves the head of a department. It implements the Command interface.
 @author Elvira Solnyshkina
 */

package com.university.app.commands.impl;

import com.university.app.commands.Command;
import com.university.app.services.DepartmentService;
import java.util.Scanner;

public class HeadOfDepartmentCommand implements Command {
    private final DepartmentService departmentService;

    public HeadOfDepartmentCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     Executes the command by prompting the user to enter a department name
     and displaying the head of the department.
     */
    @Override
    public void execute() {
        System.out.print("Type your department: ");
        String input = new Scanner(System.in).nextLine();
        System.out.println(departmentService.getHeadOfDepartment(input));
    }
}
