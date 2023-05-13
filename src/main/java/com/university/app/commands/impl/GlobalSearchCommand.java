package com.university.app.commands.impl;

import java.util.List;
import java.util.Scanner;
import com.university.app.commands.Command;
import com.university.app.services.DepartmentService;

public class GlobalSearchCommand implements Command {
    private final DepartmentService departmentService;

    public GlobalSearchCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void execute() {
        System.out.print("Global search: ");
        String input = new Scanner(System.in).nextLine();
        List<String> result = departmentService.globalSearch(input);
        if (result.isEmpty()) {
            System.out.println("Not found");
            return;
        }
        System.out.println("Results: " + result);
    }
}
