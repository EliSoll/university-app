/**
 The GlobalSearchCommand class represents a command that performs a global search.
 It implements the Command interface.
 @author Elvira Solnyshkina
 */

package com.university.app.commands.impl;

import com.university.app.commands.Command;
import com.university.app.services.DepartmentService;
import java.util.List;
import java.util.Scanner;

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
