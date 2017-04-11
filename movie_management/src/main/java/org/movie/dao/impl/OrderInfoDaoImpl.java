package org.movie.dao.impl;

import org.movie.dao.inf.OrderInfoDao;
import org.movie.entity.FilmInfo;
import org.movie.entity.OrderInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("orderInfoDao")
public class OrderInfoDaoImpl extends BaseDaoImpl implements OrderInfoDao{

    @Override
    public List<OrderInfo> findOrderInfoByFilmId(FilmInfo filmInfo) {
        String jpql = "from OrderInfo o left join fetch o.users left join fetch o.filmScreenings left join fetch o.filmScreenings.filmInfo left join fetch o.seatNumbers where o.filmScreenings.filmInfo.filmId = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,filmInfo.getFilmId());
        return query.getResultList();
    }

    @Override
    public OrderInfo findOrderInfoById(OrderInfo orderInfo) {
        String jpql = "from OrderInfo o left join fetch o.seatNumbers where o.orderInfoId = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,orderInfo.getOrderInfoId());
        return (OrderInfo) query.getSingleResult();
    }
}
