package org.movie.action;

import org.movie.entity.Area;
import org.movie.exception.AreaException;
import org.movie.service.inf.AreaService;
import org.movie.util.RelieveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Describe
 * Created by Wkz on 2017/3/15.
 */
@Controller("areaAction")
@Scope("prototype")
public class AreaAction {

    //注入service
    @Autowired
    @Qualifier("areaService")
    private AreaService service;

    private Area area;
    private List<Area> list;

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Area> getList() {
        return list;
    }

    public void setList(List<Area> list) {
        this.list = list;
    }

    //添加区（县）信息
    public String addArea(){
        if(service.addArea(area)){
            return "success";
        }else{
            throw new AreaException("添加失败,该地区已存在！");
        }

    }

    //根据城市id查询该城市的所有区（县）
    public String findAreaByCityId(){
        list = service.findAreaByCityId(area.getCity());
        for (Area area:list) {
            RelieveUtil.relieve(area);
        }
        return "success";
    }

    //查询所有的区（县）
    public String findAreas(){
        list = service.findAreas();
        for (Area area:list) {
            RelieveUtil.relieve(area);
        }
        return "success";
    }

    //修改区（县）信息
    public String updateArea(){
        try {
            service.update(area);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            throw new AreaException("修改失败，请刷新后重试！");
        }
    }
}
