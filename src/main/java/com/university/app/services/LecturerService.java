package com.university.app.services;

import java.util.List;
import com.university.app.models.Lecturer;

public interface LecturerService {
    List<Lecturer> saveAllLecturers(List<Lecturer> lecturerList);
}
