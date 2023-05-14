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

    public List<Lecturer> saveAllLecturers(List<Lecturer> lecturerList) {
        return lecturerRepository.saveAll(lecturerList);
    }
}
