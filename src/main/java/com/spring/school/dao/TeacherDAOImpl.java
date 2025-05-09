package com.spring.school.dao;

import com.spring.school.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDAOImpl implements TeacherDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Teacher getTeacherByCode(String teacherCode) {
        Session session = sessionFactory.getCurrentSession();
        Query<Teacher> query = session.createQuery("from Teacher " + "where entryCode =:teacherCode");
        query.setParameter("teacherCode", teacherCode);
        Teacher teacher = query.uniqueResult();
        return teacher;
    }
}
