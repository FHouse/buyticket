package org.movie.action;

import org.movie.entity.FilmType;
import org.movie.service.inf.FilmTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Describe
 * Created by Wkz on 2017/3/28.
 */
@Controller("filmTypeAction")
@Scope("prototype")
public class FilmTypeAction {

    //注入service
    @Autowired
    @Qualifier("filmTypeService")
    private FilmTypeService service;

    private FilmType filmType;
    private List<FilmType> list;
    private String message;

    public FilmType getFilmType() {
        return filmType;
    }

    public void setFilmType(FilmType filmType) {
        this.filmType = filmType;
    }

    public List<FilmType> getList() {
        return list;
    }

    public void setList(List<FilmType> list) {
        this.list = list;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //添加电影类型
    public String addFilmType(){
        service.addFilmType(filmType);
        return "success";
    }

    //修改电影类型
    public String updateFilmType(){
        try{
            service.updateFilmType(filmType);
            message = "修改成功！";
        }catch(Exception e){
            e.printStackTrace();
            message = "修改失败！";
        }
        return "success";
    }

    //查询所有电影类型
    public String findFilmTypes(){
        list = service.findFilmTypes();
        return "success";
    }
}
