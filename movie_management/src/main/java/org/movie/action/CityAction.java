package org.movie.action;

import org.movie.entity.City;
import org.movie.exception.CityException;
import org.movie.service.inf.BaseService;
import org.movie.service.inf.CityService;
import org.movie.util.RelieveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;

import java.util.List;

import static javafx.scene.input.KeyCode.Q;

/**
 * Describe
 * Created by Wkz on 2017/3/15.
 */
@Controller("cityAction")
@Scope("prototype")
public class CityAction {
    //注入service
    @Autowired
    @Qualifier("cityService")
    private CityService service;

    private City city;
    private List<City> list;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<City> getList() {
        return list;
    }

    public void setList(List<City> list) {
        this.list = list;
    }

    //添加城市信息
    public String addCitys(){
        if(service.add(city)){
            return "success";
        }else{
            throw new CityException("添加失败，该城市已存在！");
        }
    }

    //查询所有城市信息
    public String findCitys(){
        list = service.findCitys();
        for (City city:list) {
            RelieveUtil.relieve(city);
        }
        return "success";
    }


    //修改城市信息
    public String updateCity(){
        try {
            service.update(city);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            throw new CityException("修改失败，请刷新后重试！");
        }
    }
}
