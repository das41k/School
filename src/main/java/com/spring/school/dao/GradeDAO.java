package com.spring.school.dao;

import com.spring.school.entity.Grade;
import com.spring.school.entity.Squad;
import com.spring.school.entity.Subject;

import java.util.List;

public interface GradeDAO {
    List<Grade> getGradesBySquadAndSubject(int squadId, int subjectId);
    void deleteGrade(int gradeId);
    Grade getGradeById(int gradeId);
}
