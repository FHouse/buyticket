package org.movie.service.impl;

import org.movie.dao.impl.AreaDaoImpl;
import org.movie.dao.inf.AreaDao;
import org.movie.entity.Area;
import org.movie.service.inf.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "adminService" )
@Transactional
public class AreaServiceImpl extends BaseServiceImpl implements AreaService{

    //注入dao
    @Autowired
    @Qualifier("areaDao")
    private AreaDaoImpl dao;
}
