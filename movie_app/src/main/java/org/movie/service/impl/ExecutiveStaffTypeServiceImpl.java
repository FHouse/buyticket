package org.movie.service.impl;

import org.movie.dao.inf.ExecutiveStaffTypeDao;
import org.movie.service.inf.ExecutiveStaffTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "executiveStaffTypeService" )
@Transactional
public class ExecutiveStaffTypeServiceImpl extends BaseServiceImpl implements ExecutiveStaffTypeService{

    //注入dao
    @Autowired
    @Qualifier("executiveStaffTypeDao")
    private ExecutiveStaffTypeDao dao;

}