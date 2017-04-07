package org.movie.service.impl;

import org.movie.dao.inf.ExecutiveStaffTypeDao;
import org.movie.entity.ExecutiveStaffType;
import org.movie.service.inf.ExecutiveStaffTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<ExecutiveStaffType> findExecutiveStaffTypes() {
        return dao.findAll(ExecutiveStaffType.class);
    }
}
