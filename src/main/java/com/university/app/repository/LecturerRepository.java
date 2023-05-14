/**
 Repository interface for managing Lecturer entities.
 Provides methods for CRUD operations and custom queries on the lecturers.
 This interface extends the JpaRepository interface to inherit common persistence operations.
 @see com.university.app.models.Lecturer
 @author Elvira Solnyshkina
 */

package com.university.app.repository;

import com.university.app.models.Lecturer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long> {
    /**
     Finds lecturers whose name contains the specified template (case-insensitive).
     @param name the template to search for in the lecturer names
     @return a list of lecturers whose names contain the specified template
     */
    List<Lecturer> findByNameContainingIgnoreCase(String name);
}
