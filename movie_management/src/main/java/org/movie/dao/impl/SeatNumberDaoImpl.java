package org.movie.dao.impl;

import org.movie.dao.inf.SeatNumberDao;
import org.movie.entity.SeatNumber;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("SeatNumberDao")
public class SeatNumberDaoImpl extends BaseDaoImpl implements SeatNumberDao{
    @Override
    public List<SeatNumber> findSeatNumber() {
        String jpql = "from SeatNumber";
        return em.createQuery(jpql).getResultList();
    }
}
