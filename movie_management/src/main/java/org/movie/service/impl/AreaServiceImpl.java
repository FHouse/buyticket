package org.movie.service.impl;

import org.movie.dao.inf.AreaDao;
import org.movie.entity.Area;
import org.movie.service.inf.AreaService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "AdminService" )
public class AreaServiceImpl extends BaseServiceImpl implements AreaService{
    private AreaDao dao;
    @Override
    public List<Area> findArea() {
        return dao.findArea();
    }
}
