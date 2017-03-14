package org.movie.service.impl;

import org.movie.dao.inf.OrderInfoDao;
import org.movie.entity.OrderInfo;
import org.movie.service.inf.OrderInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "OrderInfoService" )
public class OrderInfoServiceImpl extends BaseServiceImpl implements OrderInfoService{
    private OrderInfoDao dao;
    @Override
    public List<OrderInfo> findOrderInfo() {
        return dao.findOrderInfo();
    }
}
