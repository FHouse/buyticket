package org.movie.dao.inf;

import org.movie.entity.FilmInfo;
import org.movie.entity.OrderInfo;

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
    public List<OrderInfo> findOrderInfoByFilmId(FilmInfo filmInfo);
}
