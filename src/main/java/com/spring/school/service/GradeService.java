package com.spring.school.service;

import com.spring.school.entity.Grade;

import java.util.List;

public interface GradeService {
    List<Grade> getGradesBySquadAndSubject(int squadId, int subjectId);
    void deleteGrade(int gradeId);
    Grade getGradeById(int gradeId);
}
