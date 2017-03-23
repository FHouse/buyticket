package org.movie.service.inf;

import org.movie.entity.City;

import java.util.List;

/**
 * 城市服务类接口
 * Created by admin on 2017/3/14.
 */
public interface CityService{

    /**
     * 添加城市
     * @param city 需要添加的城市
     * @return 返回添加信息
     */
    public void add(City city);

    /**
     * 查询所有城市
     * @return 返回所有城市的一个集合
     */
    public List<City> findCitys();

    /**
     * 修改城市信息
     * @param city 需要修改的城市的城市信息
     * @return 返回修改后的结果
     */
    public void update(City city) throws Exception;

}
