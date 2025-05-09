package com.spring.school.service;

import com.spring.school.dao.SquadDAO;
import com.spring.school.dao.SquadDAOImpl;
import com.spring.school.entity.Squad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SquadServiceImpl implements SquadService {

    @Autowired
    private SquadDAO squadDAO;

    @Override
    @Transactional
    public List<Squad> getAllSquads() {
        return squadDAO.getAllSquads();
    }
}
