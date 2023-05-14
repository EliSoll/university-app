/**
 * Implementation of the {@link DepartmentService} interface
 * that provides functionality to manage departments.
 * This service interacts with the {@link DepartmentRepository}
 * and {@link LecturerRepository} to perform
 * CRUD operations and retrieve information related to departments and lecturers.
 *
 * @author Elvira Solnyshkina
 * @version 1.0
 * @see DepartmentService
 * @see DepartmentRepository
 * @see LecturerRepository
 */

package com.university.app.services.impl;

import com.university.app.dto.DepartmentStatistics;
import com.university.app.models.AcademicDegree;
import com.university.app.models.Department;
import com.university.app.models.Lecturer;
import com.university.app.repository.DepartmentRepository;
import com.university.app.repository.LecturerRepository;
import com.university.app.services.DepartmentService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    public static final String CORRECT_YOUR_COMMAND = "Please, correct your command.";
    private final DepartmentRepository departmentRepository;

    private final LecturerRepository lecturerRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository,
                                 LecturerRepository lecturerRepository) {
        this.departmentRepository = departmentRepository;
        this.lecturerRepository = lecturerRepository;
    }

    /**
     * Saves a department.
     *
     * @param department the department to save
     */
    public void save(Department department) {
        departmentRepository.save(department);
    }

    /**
     * Retrieves the head of department by department name.
     *
     * @param departmentName the name of the department
     * @return the head of the department
     */
    public String getHeadOfDepartment(String departmentName) {
        Department department = departmentRepository.findDepartmentByName(departmentName);
        if (!checkExistenceOfDepartment(department)) {
            return CORRECT_YOUR_COMMAND;
        }
        System.out.print("Head of " + department.getName() + " department is ");
        return department.getHeadOfDepartment().getName();
    }

    /**
     * Retrieves the statistics of a department, including
     * the number of assistants, associate professors,
     * and professors in the department.
     *
     * @param departmentName the name of the department
     * @return the department statistics
     */
    public DepartmentStatistics getDepartmentStatistics(String departmentName) {
        Department department = departmentRepository.findDepartmentByName(departmentName);
        if (!checkExistenceOfDepartment(department)) {
            System.out.println(CORRECT_YOUR_COMMAND);
            return new DepartmentStatistics(0, 0, 0);
        }
        long assistantCount = department.getLecturers()
                .stream()
                .filter(l -> l.getAcademicDegree() == AcademicDegree.ASSISTANT)
                .count();
        long associateProfessorCount = department.getLecturers()
                .stream()
                .filter(l -> l.getAcademicDegree() == AcademicDegree.ASSOCIATE_PROFESSOR)
                .count();
        long professorCount = department.getLecturers()
                .stream()
                .filter(l -> l.getAcademicDegree() == AcademicDegree.PROFESSOR)
                .count();
        return new DepartmentStatistics(assistantCount, associateProfessorCount, professorCount);
    }

    /**
     * Retrieves the average salary for the department.
     *
     * @param departmentName the name of the department
     * @return the average salary of the department
     */
    public double getAverageSalary(String departmentName) {
        Department department = departmentRepository.findDepartmentByName(departmentName);
        if (!checkExistenceOfDepartment(department)) {
            System.out.println(CORRECT_YOUR_COMMAND);
            return 0;
        }
        System.out.println("The average salary of " + department.getName() + " is: ");
        return department.getLecturers().stream()
                .mapToDouble(Lecturer::getSalary)
                .average()
                .orElse(0.0);
    }

    /**
     * Retrieves the employee count for the department.
     *
     * @param departmentName the name of the department
     * @return the employee count of the department
     */
    public int getEmployeeCount(String departmentName) {
        Department department = departmentRepository.findDepartmentByName(departmentName);
        if (!checkExistenceOfDepartment(department)) {
            System.out.println(CORRECT_YOUR_COMMAND);
            return 0;
        }
        System.out.println("Out team is still growing! Now we have: ");
        return department.getLecturers().size();
    }

    /**
     * Performs a global search by the given template and retrieves
     * a list of matching names. The search is case-insensitive and looks for lecturers
     * whose names contain the provided template.
     *
     * @param template the search template
     * @return the list of matching
     */
    public List<String> globalSearch(String template) {
        List<String> result = lecturerRepository.findByNameContainingIgnoreCase(template).stream()
                .map(Lecturer::getName)
                .toList();
        return result;
    }

    /**
     * Checks the existence of a department and displays
     * the list of available departments if not found.
     *
     * @param department the department to check
     * @return true if the department exists, false otherwise
     */
    private boolean checkExistenceOfDepartment(Department department) {
        if (department == null) {
            System.out.println("Ooops! Can't find this department."
                    + " We have another amazing departments:");
            departmentRepository.findAll().stream()
                    .map(Department::getName)
                    .forEach(System.out::println);
            return false;
        }
        return true;
    }
}
