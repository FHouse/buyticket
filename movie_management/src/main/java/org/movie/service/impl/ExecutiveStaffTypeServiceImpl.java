package org.movie.service.impl;

import org.movie.dao.inf.ExecutiveStaffTypeDao;
import org.movie.entity.ExecutiveStaffType;
import org.movie.service.inf.ExecutiveStaffTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "ExecutiveStaffTypeService" )
public class ExecutiveStaffTypeServiceImpl extends BaseServiceImpl implements ExecutiveStaffTypeService{
    private ExecutiveStaffTypeDao dao;
    @Override
    public List<ExecutiveStaffType> findExecutiveStaffType() {
        return dao.findExecutiveStaffType();
    }
}
