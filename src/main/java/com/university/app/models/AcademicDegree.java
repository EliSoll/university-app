package com.university.app.models;

import org.springframework.stereotype.Component;

@Component
public enum AcademicDegree {
    ASSISTANT,
    ASSOCIATE_PROFESSOR,
    PROFESSOR;

    AcademicDegree() {
    }
}