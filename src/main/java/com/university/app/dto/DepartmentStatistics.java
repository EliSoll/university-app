/**
 DepartmentStatistics represents the statistics of a department,
 including the count of assistants, associate professors, and professors.
 This class is not recommended to be replaced with a record due to potential
 conflicts with the current Checkstyle version.
 @author Elvira Solnyshkina
 */

package com.university.app.dto;

import java.util.Objects;

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

    public long assistantCount() {
        return assistantCount;
    }

    public long associateProfessorCount() {
        return associateProfessorCount;
    }

    public long professorCount() {
        return professorCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (DepartmentStatistics) obj;
        return this.assistantCount == that.assistantCount
                && this.associateProfessorCount == that.associateProfessorCount
                && this.professorCount == that.professorCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(assistantCount, associateProfessorCount, professorCount);
    }

    @Override
    public String toString() {
        return "DepartmentStatistics["
                + "assistantCount=" + assistantCount + ", "
                + "associateProfessorCount=" + associateProfessorCount + ", "
                + "professorCount=" + professorCount + ']';
    }

}
