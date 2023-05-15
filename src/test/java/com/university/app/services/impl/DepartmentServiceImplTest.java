package com.university.app.services.impl;

import com.university.app.dto.DepartmentStatistics;
import com.university.app.models.AcademicDegree;
import com.university.app.models.Department;
import com.university.app.models.Lecturer;
import com.university.app.repository.DepartmentRepository;
import com.university.app.repository.LecturerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class DepartmentServiceImplTest {

    public static final String TEST_DEPARTMENT = "Computer Science";
    public static final String LECTURER_1 = "John Snow";
    public static final String LECTURER_2 = "Alice Smith";
    public static final String LECTURER_3 = "Bob Bobson";
    public static final String TEMPLATE = "John";
    public static final int SALARY_PROFESSOR = 10000;
    public static final int SALARY_ASSISTANT = 5000;
    public static final int SALARY_PROFESSOR_MIN = 8000;
    public static final double EXPECTED_AVERAGE = 6500.0;
    @Mock
    private DepartmentRepository departmentRepository;

    @Mock
    private LecturerRepository lecturerRepository;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveDepartmentTest() {
        Department department = new Department(TEST_DEPARTMENT, new Lecturer(LECTURER_1,
                AcademicDegree.PROFESSOR, SALARY_PROFESSOR));
        departmentService.save(department);
        verify(departmentRepository, times(1)).save(department);
    }

    @Test
    public void getHeadOfDepartmentTest() {
        String departmentName = TEST_DEPARTMENT;
        Department department = new Department(departmentName, new Lecturer(LECTURER_1,
                AcademicDegree.PROFESSOR, SALARY_PROFESSOR));
        when(departmentRepository.findDepartmentByName(departmentName)).thenReturn(department);

        String headOfDepartment = departmentService.getHeadOfDepartment(departmentName);

        assertEquals(LECTURER_1, headOfDepartment);
    }

    @Test
    public void getDepartmentStatisticsTest() {
        String departmentName = TEST_DEPARTMENT;
        Department department = new Department(departmentName, new Lecturer(LECTURER_1,
                AcademicDegree.PROFESSOR, SALARY_PROFESSOR));
        department.getLecturers().add(new Lecturer(LECTURER_1, AcademicDegree.ASSISTANT, SALARY_ASSISTANT));
        department.getLecturers().add(new Lecturer(LECTURER_3, AcademicDegree.PROFESSOR, SALARY_PROFESSOR_MIN));
        when(departmentRepository.findDepartmentByName(departmentName)).thenReturn(department);

        DepartmentStatistics statistics = departmentService.getDepartmentStatistics(departmentName);

        assertEquals(1, statistics.getAssistantCount());
        assertEquals(1, statistics.getProfessorCount());
    }

    @Test
    public void getAverageSalaryTest() {
        String departmentName = TEST_DEPARTMENT;
        Department department = new Department(departmentName, new Lecturer(LECTURER_1,
                AcademicDegree.PROFESSOR, SALARY_PROFESSOR));
        department.getLecturers().add(new Lecturer(LECTURER_2,
                AcademicDegree.ASSISTANT, SALARY_ASSISTANT));
        department.getLecturers().add(new Lecturer(LECTURER_3,
                AcademicDegree.PROFESSOR, SALARY_PROFESSOR_MIN));
        when(departmentRepository.findDepartmentByName(departmentName)).thenReturn(department);

        double averageSalary = departmentService.getAverageSalary(departmentName);

        assertEquals(EXPECTED_AVERAGE, averageSalary, 0.01);
    }

    @Test
    public void getEmployeeCountTest() {
        String departmentName = TEST_DEPARTMENT;
        Department department = new Department(departmentName, new Lecturer(LECTURER_1,
                AcademicDegree.PROFESSOR, SALARY_PROFESSOR));
        department.getLecturers().add(new Lecturer(LECTURER_2,
                AcademicDegree.ASSISTANT, SALARY_ASSISTANT));
        department.getLecturers().add(new Lecturer(LECTURER_3,
                AcademicDegree.PROFESSOR, SALARY_PROFESSOR_MIN));
        when(departmentRepository.findDepartmentByName(departmentName)).thenReturn(department);

        int employeeCount = departmentService.getEmployeeCount(departmentName);

        assertEquals(2, employeeCount);
    }

    @Test
    public void globalSearchTest() {
        String template = TEMPLATE;
        List<Lecturer> lecturers = new ArrayList<>();
        lecturers.add(new Lecturer(LECTURER_1, AcademicDegree.PROFESSOR, SALARY_PROFESSOR));
        lecturers.add(new Lecturer(LECTURER_2, AcademicDegree.ASSISTANT, SALARY_ASSISTANT));
        lecturers.add(new Lecturer(LECTURER_3, AcademicDegree.PROFESSOR, SALARY_PROFESSOR_MIN));
        when(lecturerRepository.findByNameContainingIgnoreCase(template)).thenReturn(lecturers);

        List<String> result = departmentService.globalSearch(template);

        assertEquals(3, result.size());
        assertTrue(result.contains(LECTURER_1));
        assertTrue(result.contains(LECTURER_2));
        assertTrue(result.contains(LECTURER_3));
    }
}
