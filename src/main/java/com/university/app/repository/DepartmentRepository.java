/**
 * Repository interface for managing Department entities.
 * Provides methods for CRUD operations and custom queries on the departments.
 * This interface extends the JpaRepository interface to inherit common persistence operations.
 *
 * @author Elvira Solnyshkina
 * @see com.university.app.models.Department
 */

package com.university.app.repository;

import com.university.app.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    /**
     Finds a department by its name.
     @param name the name of the department
     @return the department with the specified name, or null if not found
     */
    Department findDepartmentByName(String name);
}
