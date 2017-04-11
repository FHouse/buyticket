package org.movie.dao.inf;

import org.movie.entity.City;

/**
 * Created by admin on 2017/3/14.
 */
public interface CityDao extends BaseDao{
    public City findCityByCityName(City city);
}
