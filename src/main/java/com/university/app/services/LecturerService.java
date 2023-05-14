package com.university.app.services;

import com.university.app.models.Lecturer;
import java.util.List;

public interface LecturerService {
    List<Lecturer> saveAllLecturers(List<Lecturer> lecturerList);
}
