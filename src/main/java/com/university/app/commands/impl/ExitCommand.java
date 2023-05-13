package com.university.app.commands.impl;

import java.util.Scanner;
import com.university.app.commands.Command;
import com.university.app.services.DepartmentService;

public class ExitCommand implements Command {
    private final DepartmentService departmentService;
    public ExitCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void execute() {
        System.out.print("See you!\n");
    }
}
