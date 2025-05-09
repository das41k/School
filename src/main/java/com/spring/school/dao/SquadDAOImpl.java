package com.spring.school.dao;

import com.spring.school.entity.Squad;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SquadDAOImpl implements SquadDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Squad> getAllSquads() {
        Session session = sessionFactory.getCurrentSession();
        List<Squad> squads = session.createQuery("from Squad").getResultList();
        return squads;
    }
}
