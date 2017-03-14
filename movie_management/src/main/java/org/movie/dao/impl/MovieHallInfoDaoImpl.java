package org.movie.dao.impl;

import org.movie.dao.inf.MovieHallInfoDao;
import org.movie.entity.MovieHallInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("MovieHallInfoDao")
public class MovieHallInfoDaoImpl extends BaseDaoImpl implements MovieHallInfoDao{
    @Override
    public List<MovieHallInfo> findMovieHallInfo() {
        String jpql = "from MovieHallInfo";
        return em.createQuery(jpql).getResultList();
    }
}
