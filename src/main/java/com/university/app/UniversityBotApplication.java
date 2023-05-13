package com.university.app;

import com.university.app.models.AcademicDegree;
import com.university.app.models.Department;
import com.university.app.models.Lecturer;
import com.university.app.repositories.DepartmentRepository;
import com.university.app.repositories.LecturerRepository;
import com.university.app.services.impl.DepartmentServiceImpl;
import com.university.app.services.impl.LecturerServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = "com.university.app.services")
public class UniversityBotApplication implements CommandLineRunner {
    private final DepartmentServiceImpl departmentService;
    private final LecturerServiceImpl lectorService;
    private final LecturerRepository lecturerRepository;
    private final DepartmentRepository departmentRepository;

    public UniversityBotApplication(DepartmentServiceImpl departmentService,
                                    LecturerServiceImpl lectorService,
                                    LecturerRepository lecturerRepository,
                                    DepartmentRepository departmentRepository) {
        this.departmentService = departmentService;
        this.lectorService = lectorService;
        this.lecturerRepository = lecturerRepository;
        this.departmentRepository = departmentRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(UniversityBotApplication.class, args);
    }

    @Override
    public void run(String... args) {
        injectData();
        showGreetings();
        showCommands();
    }

    public void showGreetings() {
        String greetings = "Hi! My name is Lucky!\n"
                + "I am simple, but pretty amazing info bot.\n"
                + "Choose your command for obtaining more information about your university!\n";
        System.out.print(greetings);
    }

    public void showCommands() {
        String menu = "___________________________________________________\n"
                + "Type 1: Who is head of department.\n"
                + "___________________________________________________\n"
                + "Type 2: Show department statistics.\n"
                + "___________________________________________________\n"
                + "Type 3: Show the average salary for the department.\n"
                + "___________________________________________________\n"
                + "Type 4: Show count of employee for the department.\n"
                + "___________________________________________________\n"
                + "Type 5: Global search.\n"
                + "___________________________________________________\n"
                + "Type 6: Exit.\n"
                + "___________________________________________________\n"
                + "Type here: ";
        System.out.print(menu);
        String input;
        Scanner scanner = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        int answer = scanner.nextInt();
        String typeName = "Type your department:";

        switch (answer) {
            case 1:
                System.out.print(typeName);
                input = in.nextLine();
                System.out.println(departmentService.getHeadOfDepartment(input));
                showCommands();
                break;
            case 2:
                System.out.print(typeName);
                input = in.nextLine();
                departmentService.getDepartmentStatistics(input);
                showCommands();
                break;
            case 3:
                System.out.print(typeName);
                input = in.nextLine();
                System.out.println(departmentService.getAverageSalary(input));
                showCommands();
                break;
            case 4:
                System.out.print(typeName);
                input = in.nextLine();
                System.out.println(departmentService.getEmployeeCount(input));
                showCommands();
                break;
            case 5:
                System.out.print("Global search: ");
                input = in.nextLine();
                System.out.println("Results: " + departmentService.globalSearch(input));
                showCommands();
                break;
            case 6:
                return;
            default:
                showCommands();
        }
    }

    public void injectData() {
        lecturerRepository.deleteAllInBatch();
        departmentRepository.deleteAllInBatch();

        Lecturer ivan = new Lecturer("Ivan Petrenko", AcademicDegree.PROFESSOR, 25000);
        Lecturer petro = new Lecturer("Petro Ivanov", AcademicDegree.PROFESSOR, 28000);
        Lecturer alice = new Lecturer("Alice Loyd", AcademicDegree.ASSOCIATE_PROFESSOR, 8000);
        Lecturer bob = new Lecturer("Bob Darren", AcademicDegree.ASSISTANT, 15000);


        Department computerScience = new Department("Computer Science", ivan);
        Department engineering = new Department("Engineering", petro);
        Department math = new Department("Math", alice);

        departmentService.save(computerScience);
        departmentService.save(engineering);
        departmentService.save(math);

        lectorService.saveAllLecturers(List.of(ivan, petro, alice, bob));

        computerScience.getLecturers().addAll(List.of(ivan, alice));
        engineering.getLecturers().addAll(Arrays.asList(petro, bob, alice));
        math.getLecturers().addAll(Arrays.asList(ivan, bob, petro, alice));

        departmentService.save(computerScience);
        departmentService.save(engineering);
        departmentService.save(math);
    }
}