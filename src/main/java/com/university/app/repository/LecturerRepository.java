package com.university.app.repository;

import com.university.app.models.Lecturer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long> {
    List<Lecturer> findByNameContainingIgnoreCase(String name);
}
