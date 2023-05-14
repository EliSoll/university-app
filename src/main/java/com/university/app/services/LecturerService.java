/**
 * The interface for managing lecturers.
 * Provides methods for saving lecturer data.
 *
 * @Author Elvira Solnyshkina
 */

package com.university.app.services;

import com.university.app.models.Lecturer;
import java.util.List;

public interface LecturerService {
    /**
     * Saves a list of lecturers.
     *
     * @param lecturerList the list of lecturers to save
     * @return the saved lecturers
     */
    List<Lecturer> saveAllLecturers(List<Lecturer> lecturerList);
}
