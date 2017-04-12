package org.movie.dao.inf;

import org.hibernate.criterion.Order;
import org.movie.entity.FilmInfo;
import org.movie.entity.OrderInfo;
import org.movie.util.PageBean;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface OrderInfoDao extends BaseDao{

    /**
     * 根据电影id查询该电影下的所有订单
     * @param filmInfo
     * @return
     */
    public PageBean findOrderInfoByFilmId(PageBean pageBean,FilmInfo filmInfo);

    /**
     * 根据订单id查询该订单的信息
     * @param orderInfo
     * @return
     */
    public OrderInfo findOrderInfoById(OrderInfo orderInfo);
}
