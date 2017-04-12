package org.movie.dao.impl;

import org.movie.dao.inf.FilmAtlasDao;
import org.movie.entity.FilmAtlas;
import org.movie.util.PageBean;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("filmAtlasDao")
public class FilmAtlasDaoImpl extends BaseDaoImpl implements FilmAtlasDao{

    @Override
    public PageBean findFilmAtlasByFilmId(PageBean pageBean,FilmAtlas filmAtlas) {
        String jpql = "from FilmAtlas a where a.filmInfo.filmId = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,filmAtlas.getFilmInfo().getFilmId());
        pageBean.setRowCount(query.getResultList().size());
        query.setFirstResult(pageBean.getFirstResult());
        query.setMaxResults(pageBean.getMaxResult());
        pageBean.setList(query.getResultList());
        return pageBean;
    }
}
