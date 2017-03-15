package org.movie.service.impl;

import org.movie.dao.inf.ExecutiveStaffInfoDao;
import org.movie.service.inf.ExecutiveStaffInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "executiveStaffInfoService" )
@Transactional
public class ExecutiveStaffInfoServiceImpl extends BaseServiceImpl implements ExecutiveStaffInfoService{

    //注入dao
    @Autowired
    @Qualifier("executiveStaffInfoDao")
    private ExecutiveStaffInfoDao dao;

}
