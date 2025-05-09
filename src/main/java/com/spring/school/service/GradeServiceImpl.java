package com.spring.school.service;

import com.spring.school.dao.GradeDAO;
import com.spring.school.entity.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeDAO gradeDAO;

    @Override
    @Transactional
    public List<Grade> getGradesBySquadAndSubject(int squadId, int subjectId) {
        return gradeDAO.getGradesBySquadAndSubject(squadId, subjectId);
    }

    @Override
    @Transactional
    public void deleteGrade(int gradeId) {
        gradeDAO.deleteGrade(gradeId);
    }

    @Override
    @Transactional
    public Grade getGradeById(int gradeId) {
        return gradeDAO.getGradeById(gradeId);
    }
}
