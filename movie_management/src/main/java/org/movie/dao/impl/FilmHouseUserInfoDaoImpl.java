package org.movie.dao.impl;

import org.movie.dao.inf.FilmHouseUserInfoDao;
import org.movie.entity.FilmHouseUserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("FilmHouseUserInfoDao")
public class FilmHouseUserInfoDaoImpl extends BaseDaoImpl implements FilmHouseUserInfoDao{
    @Override
    public List<FilmHouseUserInfo> findFilmHouseUserInfo() {
        String jpql = "from FilmHouseUserInfo";
        return em.createQuery(jpql).getResultList();
    }
}
