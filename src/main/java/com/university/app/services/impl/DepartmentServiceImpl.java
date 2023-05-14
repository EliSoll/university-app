package com.university.app.services.impl;

import com.university.app.dto.DepartmentStatistics;
import com.university.app.models.AcademicDegree;
import com.university.app.models.Department;
import com.university.app.models.Lecturer;
import com.university.app.repository.DepartmentRepository;
import com.university.app.repository.LecturerRepository;
import com.university.app.services.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    public static final String CORRECT_YOUR_COMMAND = "Please, correct your command.";
    private final DepartmentRepository departmentRepository;

    private final LecturerRepository lecturerRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, LecturerRepository lecturerRepository) {
        this.departmentRepository = departmentRepository;
        this.lecturerRepository = lecturerRepository;
    }

    public void save(Department department) {
        departmentRepository.save(department);
    }

    public String getHeadOfDepartment(String departmentName) {
        Department department = departmentRepository.findDepartmentByName(departmentName);
        if (!checkExistenceOfDepartment(department)) {
            return CORRECT_YOUR_COMMAND;
        }
        System.out.print("Head of " + departmentName + " department is ");
        return department.getHeadOfDepartment().getName();
    }

    public DepartmentStatistics getDepartmentStatistics(String departmentName) {
        Department department = departmentRepository.findDepartmentByName(departmentName);
        if (!checkExistenceOfDepartment(department)) {
            System.out.println(CORRECT_YOUR_COMMAND);
            return new DepartmentStatistics(0,0,0);
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

    public double getAverageSalary(String departmentName) {
        Department department = departmentRepository.findDepartmentByName(departmentName);
        if (!checkExistenceOfDepartment(department)) {
            System.out.println(CORRECT_YOUR_COMMAND);
            return 0;
        }
        System.out.println("The average salary of " + departmentName + " is: ");
        return department.getLecturers().stream()
                .mapToDouble(Lecturer::getSalary)
                .average()
                .orElse(0.0);
    }

    public int getEmployeeCount(String departmentName) {
        Department department = departmentRepository.findDepartmentByName(departmentName);
        if (!checkExistenceOfDepartment(department)) {
            System.out.println(CORRECT_YOUR_COMMAND);
            return 0;
        }
        System.out.println("Out team is still growing! Now we have: ");
        return department.getLecturers().size();
    }

    public List<String> globalSearch(String template) {
        List<String> result = lecturerRepository.findByNameContainingIgnoreCase(template).stream()
                .map(Lecturer::getName)
                .toList();
        return result;
    }

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
