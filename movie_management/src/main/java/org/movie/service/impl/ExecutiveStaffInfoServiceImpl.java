package org.movie.service.impl;

import org.movie.dao.inf.ExecutiveStaffInfoDao;
import org.movie.entity.ExecutiveStaffInfo;
import org.movie.entity.FilmInfo;
import org.movie.service.inf.ExecutiveStaffInfoService;
import org.movie.util.CheckVer;
import org.movie.util.PageBean;
import org.movie.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "executiveStaffInfoService" )
@Transactional
public class ExecutiveStaffInfoServiceImpl implements ExecutiveStaffInfoService{

    //注入dao
    @Autowired
    @Qualifier("executiveStaffInfoDao")
    private ExecutiveStaffInfoDao dao;

    @Override
    public void addExecutiveStaffInfo(ExecutiveStaffInfo executiveStaffInfo) {
        executiveStaffInfo.setExecutiveStaffInfoId(UUIDUtil.getUUID());
        dao.save(executiveStaffInfo);
    }

    @Override
    public void deleteExecutiveStaffInfoByID(ExecutiveStaffInfo executiveStaffInfo) {
        dao.delete(executiveStaffInfo);
    }

    @Override
    public void deleteExecutiveStaffInfoByFilmID(String filmId) {
        for (ExecutiveStaffInfo e:dao.findExecutiveStaffInfoByFilmId(filmId)) {
            e = (ExecutiveStaffInfo) dao.findById(ExecutiveStaffInfo.class,e.getExecutiveStaffInfoId());
            dao.delete(e);
        }
    }

    @Override
    public void updateExecutiveStaffInfo(ExecutiveStaffInfo executiveStaffInfo) throws Exception {
        ExecutiveStaffInfo executiveStaffInfo1 = (ExecutiveStaffInfo) dao.findById(ExecutiveStaffInfo.class,executiveStaffInfo.getExecutiveStaffInfoId());
        executiveStaffInfo1 = CheckVer.checkVer(executiveStaffInfo1,executiveStaffInfo,ExecutiveStaffInfo.class);
        dao.update(executiveStaffInfo1);
    }

    @Override
    public PageBean findExecutiveStaffInfos(PageBean pageBean) {
        return dao.findAll(pageBean,ExecutiveStaffInfo.class);
    }

    @Override
    public PageBean findExecutiveStaffInfoByFilmId(PageBean pageBean, FilmInfo filmInfo) {
        return dao.findExecutiveStaffInfoByFilmId(pageBean,filmInfo);
    }

}
