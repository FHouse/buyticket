package org.movie.action;

import com.google.gson.Gson;
import org.movie.entity.FilmInfo;
import org.movie.entity.FilmYears;
import org.movie.exception.FilmYearsException;
import org.movie.service.inf.FilmYearsService;
import org.movie.util.RelieveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Describe
 * Created by Wkz on 2017/3/28.
 */
@Controller("filmYearsAction")
@Scope("prototype")
public class FilmYearsAction {

    //注入service
    @Autowired
    @Qualifier("filmYearsService")
    private FilmYearsService service;

    private FilmYears filmYears;
    private String message;
    private List<FilmYears> list;

    public FilmYears getFilmYears() {
        return filmYears;
    }

    public void setFilmYears(FilmYears filmYears) {
        this.filmYears = filmYears;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FilmYears> getList() {
        return list;
    }

    public void setList(List<FilmYears> list) {
        this.list = list;
    }

    //添加电影年代
    public String addFilmYears(){
        if(service.addFilmYears(filmYears)){
            return "success";
        }else{
            throw new FilmYearsException("添加失败！");
        }
    }

    //修改电影年代
    public String updateFilmYears(){
        try {
            service.updateFilmYears(filmYears);
            return "success";
        } catch (Exception e) {
            throw new FilmYearsException("该数据已被修改，刷新后重试！");
        }
    }

    //查询所有电影年代
    public String findFilmYeras(){
        list = service.findFilmYears();
        for (FilmYears y:list) {
            RelieveUtil.relieve(y);
        }
        System.out.println(new Gson().toJson(list));
        return "success";
    }
}
