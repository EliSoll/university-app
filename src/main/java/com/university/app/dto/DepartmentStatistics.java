/**
 DepartmentStatistics represents the statistics of a department,
 including the count of assistants, associate professors, and professors.

 * This class is not recommended to be replaced with a record due to potential
 conflicts with the current Checkstyle version.
 @author Elvira Solnyshkina
 */

package com.university.app.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public final class DepartmentStatistics {
    private final long assistantCount;
    private final long associateProfessorCount;
    private final long professorCount;

    public DepartmentStatistics(long assistantCount,
                                long associateProfessorCount,
                                long professorCount) {
        this.assistantCount = assistantCount;
        this.associateProfessorCount = associateProfessorCount;
        this.professorCount = professorCount;
    }
}
