/**
 The Lecturer class represents a lecturer entity in the university system.
 It contains information about the lecturer's ID, name, academic degree, and salary.
 @author Elvira Solnyshkina
 @version 1.0
 */

package com.university.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "lecturers")
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "degree")
    @Enumerated(EnumType.STRING)
    private AcademicDegree academicDegree;

    @Column(name = "salary")
    private int salary;

    public Lecturer(String name, AcademicDegree academicDegree, int salary) {
        this.name = name;
        this.academicDegree = academicDegree;
        this.salary = salary;
    }

    public Lecturer() {
    }
}
