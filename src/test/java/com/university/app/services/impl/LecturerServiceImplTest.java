package com.university.app.services.impl;

import com.university.app.models.AcademicDegree;
import com.university.app.models.Lecturer;
import com.university.app.repository.LecturerRepository;
import com.university.app.services.LecturerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LecturerServiceImplTest {
    public static final String LECTURER_1 = "Alice Smith";
    public static final String LECTURER_2 = "John Snow";
    public static final int SALARY_ASSISTANT = 5000;
    public static final int SALARY_PROFESSOR = 10000;
    @Mock
    private LecturerRepository lecturerRepository;

    private LecturerService lecturerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        lecturerService = new LecturerServiceImpl(lecturerRepository);
    }

    @Test
    public void saveAllLecturersTest() {
        List<Lecturer> lecturerList = new ArrayList<>();
        lecturerList.add(new Lecturer(LECTURER_1, AcademicDegree.ASSISTANT, SALARY_ASSISTANT));
        lecturerList.add(new Lecturer(LECTURER_2,AcademicDegree.PROFESSOR, SALARY_PROFESSOR));
        when(lecturerRepository.saveAll(lecturerList)).thenReturn(lecturerList);

        List<Lecturer> savedLecturers = lecturerService.saveAllLecturers(lecturerList);
        assertEquals(lecturerList.size(), savedLecturers.size());
        verify(lecturerRepository, times(1)).saveAll(lecturerList);
    }
}