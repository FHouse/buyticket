package org.movie.action;

import org.movie.entity.Area;
import org.movie.service.inf.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by admin on 2017/3/29.
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

    //根据城市id查询该城市的所有区（县）
    public String findAreaByCityId(){
        list = service.findAreaByCityId(area.getCity());
        return "success";
    }

    //查询所有的区（县）
    public String findAreas(){
        list = service.findAreas();
        return "success";
    }
}
