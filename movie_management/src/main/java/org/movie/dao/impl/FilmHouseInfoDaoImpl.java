package org.movie.dao.impl;

import org.movie.dao.inf.FilmHouseInfoDao;
import org.movie.entity.FilmHouseInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("FilmHouseInfoDao")
public class FilmHouseInfoDaoImpl extends BaseDaoImpl implements FilmHouseInfoDao{
    @Override
    public List<FilmHouseInfo> findFilmHouseInfo() {
        String jpql = "from FilmHouseInfo";
        return em.createQuery(jpql).getResultList();
    }
}
