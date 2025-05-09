package com.spring.school.dao;

import com.spring.school.entity.Grade;
import com.spring.school.entity.Squad;
import com.spring.school.entity.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GradeDAOImpl implements GradeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Grade> getGradesBySquadAndSubject(int squadId, int subjectId) {
        Session session =  sessionFactory.getCurrentSession();
        String hql = "SELECT g FROM Grade g " +
                "JOIN g.student s " +
                "WHERE s.squad.id = :squadId AND g.subject.id = :subjectId";


        Query<Grade> query = session.createQuery(hql, Grade.class);
        query.setParameter("squadId", squadId);
        query.setParameter("subjectId", subjectId);

        return query.getResultList();
    }

    @Override
    public void deleteGrade(int gradeId) {
        Session session =  sessionFactory.getCurrentSession();
        session.delete(session.get(Grade.class, gradeId));
    }

    @Override
    public Grade getGradeById(int gradeId) {
        Session session =  sessionFactory.getCurrentSession();
        return session.get(Grade.class, gradeId);
    }
}
