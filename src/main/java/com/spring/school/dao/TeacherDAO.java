package com.spring.school.dao;


import com.spring.school.entity.Teacher;

public interface TeacherDAO {
    Teacher getTeacherByCode(String teacherCode);
}
