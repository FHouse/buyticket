package org.movie.service.impl;

import org.movie.dao.inf.ExecutiveStaffInfoDao;
import org.movie.entity.ExecutiveStaffInfo;
import org.movie.service.inf.ExecutiveStaffInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "ExecutiveStaffInfoService" )
public class ExecutiveStaffInfoServiceImpl extends BaseServiceImpl implements ExecutiveStaffInfoService{
    private ExecutiveStaffInfoDao dao;
    @Override
    public List<ExecutiveStaffInfo> findExecutiveStaffInfo() {
        return dao.findExecutiveStaffInfo();
    }
}
