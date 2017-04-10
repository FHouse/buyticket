package org.movie.action;

import org.movie.entity.FilmType;
import org.movie.service.inf.FilmTypeService;
import org.movie.util.RelieveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by admin on 2017/3/30.
 */
@Controller("filmTypeAction")
@Scope("prototype")
public class FilmTypeAction {

    //注入service
    @Autowired
    @Qualifier("filmTypeService")
    private FilmTypeService service;

    private List<FilmType> list;

    public List<FilmType> getList() {
        return list;
    }

    public void setList(List<FilmType> list) {
        this.list = list;
    }

    //查询所有电影类型
    public String findFilmTypes() {
        list = service.findFilmTypes();
        for (FilmType filmType:list){
            RelieveUtil.relieve(filmType);
        }
        return "success";
    }
}
