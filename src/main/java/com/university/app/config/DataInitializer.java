package com.university.app.config;

import com.university.app.models.AcademicDegree;
import com.university.app.models.Department;
import com.university.app.models.Lecturer;
import com.university.app.services.DepartmentService;
import com.university.app.services.LecturerService;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final DepartmentService departmentService;
    private final LecturerService lecturerService;

    public DataInitializer(DepartmentService departmentService, LecturerService lecturerService) {
        this.departmentService = departmentService;
        this.lecturerService = lecturerService;
    }

    public void inject() {
        Lecturer ivan = new Lecturer("Ivan Petrenko", AcademicDegree.PROFESSOR, 25000);
        Lecturer petro = new Lecturer("Petro Ivanov", AcademicDegree.PROFESSOR, 28000);
        Lecturer alice = new Lecturer("Alice Loyd", AcademicDegree.ASSOCIATE_PROFESSOR, 8000);
        Lecturer bob = new Lecturer("Bob Darren", AcademicDegree.ASSISTANT, 15000);

        Department computerScience = new Department("Computer Science", ivan);
        Department engineering = new Department("Engineering", petro);
        Department math = new Department("Math", alice);
        Department dataScience = new Department("Data Science", bob);

        departmentService.save(computerScience);
        departmentService.save(engineering);
        departmentService.save(math);
        departmentService.save(dataScience);

        lecturerService.saveAllLecturers(List.of(ivan, petro, alice, bob));

        computerScience.getLecturers().addAll(List.of(ivan, alice));
        engineering.getLecturers().addAll(Arrays.asList(petro, bob, alice));
        math.getLecturers().addAll(Arrays.asList(ivan, bob, petro, alice));
        dataScience.getLecturers().addAll(Arrays.asList(bob, alice));

        departmentService.save(computerScience);
        departmentService.save(engineering);
        departmentService.save(math);
        departmentService.save(dataScience);
    }
}
