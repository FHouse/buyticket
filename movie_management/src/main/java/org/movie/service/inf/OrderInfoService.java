package org.movie.service.inf;

import org.movie.entity.FilmInfo;
import org.movie.entity.OrderInfo;
import org.movie.util.PageBean;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface OrderInfoService{

    /**
     * 修改订单
     * @param orderInfo
     */
    public void updateOrderInfo(OrderInfo orderInfo) throws Exception;

    /**
     * 删除订单
     * @param orderInfo
     */
    public void deleteOrderInfo(OrderInfo orderInfo);

    /**
     * 根据电影id查询订单
     * @param filmInfo
     */
    public PageBean findOrderInfoByFilmId(PageBean pageBean,FilmInfo filmInfo);
}
