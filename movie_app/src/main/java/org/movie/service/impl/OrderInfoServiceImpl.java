package org.movie.service.impl;

import org.movie.dao.inf.OrderInfoDao;
import org.movie.service.inf.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
