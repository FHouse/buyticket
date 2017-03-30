package org.movie.action;

import org.movie.entity.City;
import org.movie.service.inf.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by admin on 2017/3/29.
 */
@Controller("cityAction")
@Scope("prototype")
public class CityAction {
    //注入service
    @Autowired
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
