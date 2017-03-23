package org.movie.dao.impl;

import org.movie.dao.inf.FilmHouseUserInfoDao;
import org.movie.entity.FilmHouseInfo;
import org.movie.entity.FilmHouseUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("filmHouseUserInfoDao")
public class FilmHouseUserInfoDaoImpl extends BaseDaoImpl implements FilmHouseUserInfoDao{

    @Override
    public FilmHouseUserInfo findFilmHouseUserByName(FilmHouseUserInfo filmHouseUserInfo) {
        String jpql = "from FilmHouseUserInfo f where f.cinemaUserName = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,filmHouseUserInfo.getCinemaUserName());
        return (FilmHouseUserInfo) query.getSingleResult();
    }

    @Override
    public List<FilmHouseUserInfo> findFilmHouseUsersByFilmHouseId(FilmHouseInfo filmHouseInfo) {
        String jpql = "from FilmHouseUserInfo f where f.filmHouseInfo.filmHouseId = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,filmHouseInfo.getFilmHouseId());
        return query.getResultList();
    }
}
