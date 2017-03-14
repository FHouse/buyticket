package org.movie.dao.impl;

import org.movie.dao.inf.OrderInfoDao;
import org.movie.entity.OrderInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("OrderInfoDao")
public class OrderInfoDaoImpl extends BaseDaoImpl implements OrderInfoDao{
    @Override
    public List<OrderInfo> findOrderInfo() {
        String jpql = "from OrderInfo";
        return em.createQuery(jpql).getResultList();
    }
}
