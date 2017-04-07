package org.movie.action;

import org.movie.entity.FilmHouseInfo;
import org.movie.exception.FilmHouseInfoException;
import org.movie.service.inf.FilmHouseInfoService;
import org.movie.util.RelieveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Describe
 * Created by Wkz on 2017/3/17.
 */
@Controller("filmHouseInfoAction")
@Scope("prototype")
public class FilmHouseInfoAction {
    //注入service
    @Autowired
    @Qualifier("filmHouseInfoService")
    private FilmHouseInfoService service;

    private FilmHouseInfo filmHouseInfo;
    private String message;
    private List<FilmHouseInfo> list;

    public FilmHouseInfo getFilmHouseInfo() {
        return filmHouseInfo;
    }

    public void setFilmHouseInfo(FilmHouseInfo filmHouseInfo) {
        this.filmHouseInfo = filmHouseInfo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FilmHouseInfo> getList() {
        return list;
    }

    public void setList(List<FilmHouseInfo> list) {
        this.list = list;
    }

    //添加影城
    public String addFilmHouseInfo(){
        if(service.add(filmHouseInfo)){
            return "success";
        }else{
            throw new FilmHouseInfoException("该影城已存在!");
        }
    }

    //删除影城(未完成)
    public String deleteFilmHouseInfo(){
        service.delete(filmHouseInfo);
        return "success";
    }

    //查询所有的影城
    public String findFilmHouseInfos(){
        list = service.findFilmHouseInfos();
        for (FilmHouseInfo filmHouse:list) {
            RelieveUtil.relieve(filmHouse);
        }
        return "success";
    }

    //根据地区信息查询该区域所有的影城
    public String findFilmHouseInfoByAreaId(){
        list = service.findFilmHouseInfoByAreaId(filmHouseInfo.getArea());
        for (FilmHouseInfo filmHouse:list) {
            RelieveUtil.relieve(filmHouse);
        }
        return "success";
    }

    //修改影城
    public String updateFilmHouseInfo(){
        try {
            service.update(filmHouseInfo);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            throw new FilmHouseInfoException("修改失败，请刷新后重试！");
        }
    }
}
