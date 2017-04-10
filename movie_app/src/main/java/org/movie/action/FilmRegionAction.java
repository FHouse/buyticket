package org.movie.action;

import org.movie.entity.FilmRegion;
import org.movie.service.inf.FilmRegionService;
import org.movie.util.RelieveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by admin on 2017/3/30.
 */
@Controller("filmRegionAction")
@Scope("prototype")
public class FilmRegionAction {
    //注入service
    @Autowired
    @Qualifier("filmRegionService")
    private FilmRegionService service;

    private List<FilmRegion> list;

    public List<FilmRegion> getList() {
        return list;
    }

    public void setList(List<FilmRegion> list) {
        this.list = list;
    }

    //查询所有年代
    public String findFilmRegions(){
        list = service.findFilmRegions();
        for (FilmRegion filmRegion:list){
            RelieveUtil.relieve(filmRegion);
        }
        return "success";
    }
}
