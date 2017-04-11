package org.movie.service.impl;

import org.movie.dao.inf.ExecutiveStaffTypeDao;
import org.movie.dao.inf.OrderInfoDao;
import org.movie.entity.FilmInfo;
import org.movie.entity.OrderInfo;
import org.movie.entity.SeatNumber;
import org.movie.service.inf.OrderInfoService;
import org.movie.util.CheckVer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "orderInfoService" )
@Transactional
public class OrderInfoServiceImpl implements OrderInfoService{
    //注入dao
    @Autowired
    @Qualifier("orderInfoDao")
    private OrderInfoDao dao;

    @Override
    public void updateOrderInfo(OrderInfo orderInfo) throws Exception {
        OrderInfo orderInfo1 = (OrderInfo) dao.findById(OrderInfo.class,orderInfo.getOrderInfoId());
        orderInfo1 = CheckVer.checkVer(orderInfo1,orderInfo,OrderInfo.class);
        dao.update(orderInfo1);
    }

    @Override
    public void deleteOrderInfo(OrderInfo orderInfo) {
        orderInfo = dao.findOrderInfoById(orderInfo);
        for (SeatNumber s:orderInfo.getSeatNumbers()) {
            dao.delete(s);
        }
        dao.delete(orderInfo);
    }

    @Override
    public List<OrderInfo> findOrderInfoByFilmId(FilmInfo filmInfo) {
        return dao.findOrderInfoByFilmId(filmInfo);
    }
}
