package com.university.app.commands.impl;

import java.util.Scanner;
import com.university.app.commands.Command;
import com.university.app.services.DepartmentService;
import com.university.app.dto.DepartmentStatistics;


public class DepartmentStatisticsCommand implements Command {
    private final DepartmentService departmentService;

    public DepartmentStatisticsCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void execute() {
        System.out.print("Type your department: ");
        String input = new Scanner(System.in).nextLine();
        DepartmentStatistics stats = departmentService.getDepartmentStatistics(input);
        System.out.println("Assistants: " + stats.assistantCount());
        System.out.println("Associate professors: " + stats.associateProfessorCount());
        System.out.println("Professors: " + stats.professorCount());
    }
}