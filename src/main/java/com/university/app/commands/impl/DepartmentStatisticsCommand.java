/**
 The DepartmentStatisticsCommand class represents a command
 that retrieves and displays the statistics of a department,
 including the number of assistants, associate professors,
 and professors. It implements the Command interface.
 @author Elvira Solnyshkina
 */

package com.university.app.commands.impl;

import com.university.app.commands.Command;
import com.university.app.dto.DepartmentStatistics;
import com.university.app.services.DepartmentService;
import java.util.Scanner;

public class DepartmentStatisticsCommand implements Command {
    private final DepartmentService departmentService;

    public DepartmentStatisticsCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     Executes the command by prompting the user for a department name
     and displaying the department statistics.
     The statistics include the number of assistants, associate professors,
     and professors in the department.
     */
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
