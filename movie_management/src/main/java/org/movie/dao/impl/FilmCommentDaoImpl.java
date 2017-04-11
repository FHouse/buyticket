package org.movie.dao.impl;

import org.movie.dao.inf.FilmCommentDao;
import org.movie.entity.FilmComment;
import org.movie.entity.FilmInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("filmCommentDao")
public class FilmCommentDaoImpl extends BaseDaoImpl implements FilmCommentDao{

    @Override
    public List<FilmComment> findFilmCommentByFilmId(FilmInfo filmInfo) {
        String jpql = "from FilmComment c left join fetch c.users where c.filmInfo.filmId = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,filmInfo.getFilmId());
        return query.getResultList();
    }
}
