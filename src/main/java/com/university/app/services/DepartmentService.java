package com.university.app.services;

import java.util.List;
import com.university.app.models.Department;

public interface DepartmentService {
    void save(Department department);

    String getHeadOfDepartment(String departmentName);

    void getDepartmentStatistics(String departmentName);

    double getAverageSalary(String departmentName);

    int getEmployeeCount(String departmentName);

    List<String> globalSearch(String template);
}
