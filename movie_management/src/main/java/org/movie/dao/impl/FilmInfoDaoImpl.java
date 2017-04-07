package org.movie.dao.impl;

import org.movie.dao.inf.FilmInfoDao;
import org.movie.entity.FilmInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("filmInfoDao")
public class FilmInfoDaoImpl extends BaseDaoImpl implements FilmInfoDao{

    @Override
    public FilmInfo findFilmInfoByName(FilmInfo filmInfo) {
        String jpql = "from FilmInfo f where f.filmName = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,filmInfo.getFilmName());
        return (FilmInfo) query.getSingleResult();
    }
}
