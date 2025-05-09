package com.spring.school.service;


import com.spring.school.dao.TeacherDAO;
import com.spring.school.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDAO teacherDAO;

    @Override
    @Transactional
    public Teacher getTeacherByCode(String code) {
        return teacherDAO.getTeacherByCode(code);
    }
}
