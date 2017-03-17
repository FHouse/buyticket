package org.movie.action;

import org.movie.entity.City;
import org.movie.service.inf.BaseService;
import org.movie.service.inf.CityService;
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
    private String message;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //添加城市信息
    public String addCitys(){
        try {
            service.add(city);
            message = "添加成功";
        }catch(Exception e){
            e.printStackTrace();
            message = "添加失败";
        }
        return "success";
    }

    //查询所有城市信息
    public String findCitys(){
        list = service.findCitys();
        return "success";
    }

    //删除城市信息
    public String deleteCity(){
        service.delete(city);
        return "success";
    }

    //修改城市信息
    public String updateCity(){
        try {
            service.update(city);
            message = "更新成功";
        } catch (Exception e) {
            message = "更新失败";
            e.printStackTrace();
        }
        return "success";
    }
}
