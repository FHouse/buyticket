package org.movie.dao.impl;

import org.movie.dao.inf.ExecutiveStaffInfoDao;
import org.movie.entity.ExecutiveStaffInfo;
import org.movie.entity.FilmInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("executiveStaffInfoDao")
public class ExecutiveStaffInfoDaoImpl extends BaseDaoImpl implements ExecutiveStaffInfoDao {

    @Override
    public List<ExecutiveStaffInfo> findExecutiveStaffInfoByFilmId(FilmInfo filmId) {
        String jpql = "from ExecutiveStaffInfo e where e.filmInfo.filmId = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,filmId);
        return query.getResultList();
    }
}
