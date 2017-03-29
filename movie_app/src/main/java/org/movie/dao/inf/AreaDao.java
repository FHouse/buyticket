package org.movie.dao.inf;

import org.movie.entity.Area;
import org.movie.entity.City;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface AreaDao extends BaseDao{
    public List<Area> findAreaByCityId(City city);
}
