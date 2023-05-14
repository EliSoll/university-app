/**
 The ExitCommand class represents a command that terminates the application.
 It implements the Command interface.
 @author Elvira Solnyshkina
 */

package com.university.app.commands.impl;

import com.university.app.commands.Command;
import com.university.app.services.DepartmentService;

public class ExitCommand implements Command {
    private final DepartmentService departmentService;

    public ExitCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     Executes the command by displaying a farewell message.
     End of console application.
     */
    @Override
    public void execute() {
        System.out.print("See you!\n");
    }
}
