package org.movie.service.impl;

import org.movie.dao.inf.ExecutiveStaffTypeDao;
import org.movie.entity.ExecutiveStaffType;
import org.movie.service.inf.ExecutiveStaffTypeService;
import org.movie.util.CheckVer;
import org.movie.util.UUIDUtil;
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
public class ExecutiveStaffTypeServiceImpl implements ExecutiveStaffTypeService{

    //注入dao
    @Autowired
    @Qualifier("executiveStaffTypeDao")
    private ExecutiveStaffTypeDao dao;

    @Override
    public boolean addExecutiveStaffType(ExecutiveStaffType executiveStaffType) {
        executiveStaffType.setExecutiveStaffTypeId(UUIDUtil.getUUID());
        try{
            dao.findESTypeByName(executiveStaffType);
            return false;
        }catch (Exception e){
            dao.save(executiveStaffType);
            return true;
        }
    }

    @Override
    public String deleteExecutiveStaffType(ExecutiveStaffType executiveStaffType) {
        //暂未完成
        return null;
    }

    @Override
    public void updateExecutiveStaffType(ExecutiveStaffType executiveStaffType) throws Exception {
        ExecutiveStaffType executiveStaffType1 = (ExecutiveStaffType) dao.findById(ExecutiveStaffType.class,executiveStaffType.getExecutiveStaffTypeId());
        executiveStaffType1 = CheckVer.checkVer(executiveStaffType1,executiveStaffType,ExecutiveStaffType.class);
        dao.update(executiveStaffType1);
    }

    @Override
    public List<ExecutiveStaffType> findExecutiveStaffTypes() {
        return dao.findAll(ExecutiveStaffType.class);
    }
}
