package org.movie.action;

import org.movie.entity.FilmYears;
import org.movie.service.inf.FilmYearsService;
import org.movie.util.RelieveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by admin on 2017/3/30.
 */
@Controller("filmYearsAction")
@Scope("prototype")
public class FilmYearsAction {
    //注入service
    @Autowired
    @Qualifier("filmYearsService")
    private FilmYearsService service;

    private List<FilmYears> list;

    public List<FilmYears> getList() {
        return list;
    }

    public void setList(List<FilmYears> list) {
        this.list = list;
    }

    //查询所有电影年代
    public String findFilmYeras(){
        list = service.findFilmYears();
        for (FilmYears filmYears:list){
            RelieveUtil.relieve(filmYears);
        }
        return "success";
    }
}
