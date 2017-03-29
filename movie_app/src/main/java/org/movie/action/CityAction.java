package org.movie.action;

import org.movie.entity.City;
import org.movie.service.inf.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by admin on 2017/3/29.
 */
public class CityAction {
    //注入service
    @Autowired
    @Qualifier("cityService")
    private CityService service;

    private List<City> list;

    public List<City> getList() {
        return list;
    }

    public void setList(List<City> list) {
        this.list = list;
    }

    //查询所有城市信息
    public String findCitys(){
        list = service.findCitys();
        return "success";
    }
}
