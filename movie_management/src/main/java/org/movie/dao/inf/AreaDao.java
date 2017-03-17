package org.movie.dao.inf;

import org.movie.entity.Area;
import org.movie.entity.City;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface AreaDao extends BaseDao{

    /**
     *根据城市id查询该市的所有区（县）
     * @param city 需要查询的市的信息
     * @return 返回区（县）的集合
     */
    public List<Area> findAreaByCityId(City city);

    /**
     * 根据城市id删除该市所有的区（县），
     * 主要用于在删除市的同时，级联删除该是的所有区（县）
     * @param city 需要删除的市的信息
     */
    public void deleteAreaByCityId(City city);
}
