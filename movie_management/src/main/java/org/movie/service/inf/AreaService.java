package org.movie.service.inf;

import org.movie.entity.Area;
import org.movie.entity.City;

import java.util.List;

/**
 * 区（县）类接口
 * Created by admin on 2017/3/14.
 */
public interface AreaService{

    /**
     * 添加区（县）
     * @param area 需要添加的区（县）
     * @return 返回添加结果
     */
    public void addArea(Area area);

    /**
     * 根据城市id查询该市所有的区（县）
     * @param city 城市信息
     * @return 返回该市所有的区（县）
     */
    public List<Area> findAreaByCityId(City city);

    /**
     * 查询所有的区（县）
     * @return 返回所有的区（县）的集合
     */
    public List<Area> findAreas();

    /**
     * 修改区（县）信息
     * @param area 需要修改的区（县）的信息
     * @return 返回修改结果
     */
    public void update(Area area) throws Exception;

}
