package org.movie.dao.impl;

import org.movie.dao.inf.FilmInfoDao;
import org.movie.entity.FilmInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("FilmInfoDao")
public class FilmInfoDaoImpl extends BaseDaoImpl implements FilmInfoDao{
    @Override
    public List<FilmInfo> findFilmInfo() {
        String jpql = "from FilmInfo";
        return em.createQuery(jpql).getResultList();
    }
}
