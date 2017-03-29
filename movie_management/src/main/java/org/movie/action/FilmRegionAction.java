package org.movie.action;

import org.movie.entity.FilmRegion;
import org.movie.service.inf.FilmRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Describe
 * Created by Wkz on 2017/3/28.
 */
@Controller("filmRegionAction")
@Scope("prototype")
public class FilmRegionAction {

    //注入service
    @Autowired
    @Qualifier("filmRegionService")
    private FilmRegionService service;

    private FilmRegion filmRegion;
    private String message;
    private List<FilmRegion> list;

    public FilmRegion getFilmRegion() {
        return filmRegion;
    }

    public void setFilmRegion(FilmRegion filmRegion) {
        this.filmRegion = filmRegion;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FilmRegion> getList() {
        return list;
    }

    public void setList(List<FilmRegion> list) {
        this.list = list;
    }

    //添加年代
    public String addFilmRegion(){
        service.addFilmRegion(filmRegion);
        return "success";
    }

    //修改年代
    public String updateFilmRegion(){
        try {
            service.updateFilmRegion(filmRegion);
            message = "修改成功！";
        } catch (Exception e) {
            e.printStackTrace();
            message = "修改失败！";
        }
        return "success";
    }

    //查询所有年代
    public String findFilmRegions(){
        list = service.findFilmRegions();
        return "success";
    }
}
