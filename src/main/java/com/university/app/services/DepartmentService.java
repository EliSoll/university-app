package com.university.app.services;

import com.university.app.dto.DepartmentStatistics;
import com.university.app.models.Department;
import java.util.List;

public interface DepartmentService {
    void save(Department department);

    String getHeadOfDepartment(String departmentName);

    DepartmentStatistics getDepartmentStatistics(String departmentName);

    double getAverageSalary(String departmentName);

    int getEmployeeCount(String departmentName);

    List<String> globalSearch(String template);
}
