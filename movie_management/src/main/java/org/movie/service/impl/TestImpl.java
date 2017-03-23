package org.movie.service.impl;

import org.movie.dao.inf.AreaDao;
import org.movie.entity.Area;
import org.movie.service.inf.TestInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;

/**
 * Describe
 * Created by Wkz on 2017/3/21.
 */
@Service
@Transactional
public class TestImpl implements TestInf {
    @Autowired
    @Qualifier("areaDao")
    private AreaDao dao;

    @Override
    public void delete(Area area) {

    }
}
