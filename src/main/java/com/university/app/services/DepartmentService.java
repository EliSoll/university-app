/**
 * The DepartmentService interface provides methods for managing departments in the university.
 *
 * @Author Elvira Solnyshkina
 */

package com.university.app.services;

import com.university.app.dto.DepartmentStatistics;
import com.university.app.models.Department;
import java.util.List;

public interface DepartmentService {
    /**
     * Saves a department.
     *
     * @param department the department to save
     */
    void save(Department department);

    /**
     * Retrieves the head of department by department name.
     *
     * @param departmentName the name of the department
     * @return the head of the department
     */
    String getHeadOfDepartment(String departmentName);

    /**
     * Retrieves the statistics of a department,
     * including the number of assistants, associate professors,
     * and professors in the department.
     *
     * @param departmentName the name of the department
     * @return the department statistics
     */
    DepartmentStatistics getDepartmentStatistics(String departmentName);

    /**
     * Retrieves the average salary for the department.
     *
     * @param departmentName the name of the department
     * @return the average salary of the department
     */
    double getAverageSalary(String departmentName);

    /**
     * Retrieves the employee count for the department.
     *
     * @param departmentName the name of the department
     * @return the employee count of the department
     */
    int getEmployeeCount(String departmentName);

    /**
     * Performs a global search by the given template and retrieves a list of matching names.
     *
     * @param template the search template
     * @return the list of matching names
     */
    List<String> globalSearch(String template);
}
