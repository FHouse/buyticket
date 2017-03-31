package org.movie.dao.impl;

import org.movie.dao.inf.FilmHouseInfoDao;
import org.movie.entity.Area;
import org.movie.entity.FilmHouseInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("filmHouseInfoDao")
public class FilmHouseInfoDaoImpl extends BaseDaoImpl implements FilmHouseInfoDao{

    @Override
    public List<FilmHouseInfo> findFilmHouseInfoByAreaId(Area area) {
        String jpql = "from FilmHouseInfo f where f.area.areaId = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,area.getAreaId());
        return query.getResultList();
    }

    @Override
    public void deleteFilmHouseInfoByAreaId(Area area) {
        String sql = "delete from filmhouseinfo where areaid = ?";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1,area.getAreaId());
        query.executeUpdate();
    }

    @Override
    public FilmHouseInfo findFilmHouseInfoByFilmHouseName(FilmHouseInfo filmHouseInfo) {
        String jpql = "from FilmHouseInfo f where f.filmHouseName = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,filmHouseInfo.getFilmHouseName());
        return (FilmHouseInfo) query.getSingleResult();
    }
}
