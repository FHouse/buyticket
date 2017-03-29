package org.movie.action;

import org.movie.entity.FilmHouseInfo;
import org.movie.service.inf.FilmHouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by admin on 2017/3/29.
 */
@Controller("filmHouseInfoAction")
@Scope("prototype")
public class FilmHouseInfoAction {
    //注入service
    @Autowired
    @Qualifier("filmHouseInfoService")
    private FilmHouseInfoService service;

    private FilmHouseInfo filmHouseInfo;
    private List<FilmHouseInfo> list;

    public FilmHouseInfo getFilmHouseInfo() {
        return filmHouseInfo;
    }

    public void setFilmHouseInfo(FilmHouseInfo filmHouseInfo) {
        this.filmHouseInfo = filmHouseInfo;
    }

    public List<FilmHouseInfo> getList() {
        return list;
    }

    public void setList(List<FilmHouseInfo> list) {
        this.list = list;
    }

    //根据地区信息查询该区域所有的影城
    public String findFilmHouseInfoByAreaId(){
        list = service.findFilmHouseInfoByAreaId(filmHouseInfo.getArea());
        return "success";
    }
}
