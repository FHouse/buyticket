package org.movie.dao.inf;

import org.movie.entity.City;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface CityDao extends BaseDao{

    /**
     * 根据城市名称查询该城市信息
     * @param city
     * @return
     */
    public City findCityByCityName(City city);

}
