package org.movie.service.inf;

import org.movie.entity.OrderInfo;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface OrderInfoService extends BaseService{
    public List<OrderInfo> findOrderInfo();
}
