/**

 The Department class represents a department in the university system.
 It contains information about the department's ID, name, list of lecturers,
 and the head of the department.
 @author Elvira Solnyshkina
 @version 1.0
 */

package com.university.app.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department_name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "departments_lecturers",
            joinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lecturer_id", referencedColumnName = "id"))
    private List<Lecturer> lecturers = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "head_id", referencedColumnName = "id")
    private Lecturer headOfDepartment;

    public Department(String name, Lecturer headOfDepartment) {
        this.name = name;
        this.headOfDepartment = headOfDepartment;
    }

    public Department() {
    }

    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    @Override
    public String toString() {
        return "Department{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", lectors=" + lecturers
                + ", headOfDepartment=" + headOfDepartment
                + '}';
    }
}
