package org.movie.service.impl;

import org.movie.dao.impl.AreaDaoImpl;
import org.movie.dao.inf.AreaDao;
import org.movie.entity.Area;
import org.movie.entity.City;
import org.movie.service.inf.AreaService;
import org.movie.util.CheckVer;
import org.movie.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "areaService" )
@Transactional
public class AreaServiceImpl implements AreaService{

    //注入dao
    @Autowired
    @Qualifier("areaDao")
    private AreaDaoImpl dao;

    @Override
    public void addArea(Area area) {
        area.setAreaId(UUIDUtil.getUUID());
        dao.save(area);
    }

    @Override
    public List<Area> findAreaByCityId(City city) {
        return dao.findAreaByCityId(city);
    }

    @Override
    public List<Area> findAreas() {
        return dao.findAll(Area.class);
    }

    @Override
    public void update(Area area) throws Exception {
        Area area1 = (Area) dao.findById(Area.class,area.getAreaId());
        area1  = CheckVer.checkVer(area1,area,Area.class);
        if(area1 != null){
            dao.update(area1);
        }else{
            throw new Exception("版本号不一致");
        }
    }

}
