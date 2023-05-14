/**
 * Implementation of the LecturerService interface that provides functionality to manage lecturers.
 * This service interacts with the LecturerRepository to perform CRUD operations on lecturers.
 *
 * @author Elvira Solnyshkina
 * @version 1.0
 * @see LecturerService
 * @see LecturerRepository
 */

package com.university.app.services.impl;

import com.university.app.models.Lecturer;
import com.university.app.repository.LecturerRepository;
import com.university.app.services.LecturerService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LecturerServiceImpl implements LecturerService {

    private final LecturerRepository lecturerRepository;

    public LecturerServiceImpl(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    /**
     * Saves a list of lecturers.
     *
     * @param lecturerList the list of lecturers to save
     * @return the saved lecturers
     */
    public List<Lecturer> saveAllLecturers(List<Lecturer> lecturerList) {
        return lecturerRepository.saveAll(lecturerList);
    }
}
