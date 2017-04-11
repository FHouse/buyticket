package org.movie.action;

import org.movie.entity.FilmAtlas;
import org.movie.service.inf.FilmAtlasService;
import org.movie.util.RelieveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by admin on 2017/4/10.
 */
@Controller("filmAtlasAction")
@Scope("prototype")
public class FilmAtlasAction {
    @Autowired
    @Qualifier("filmAtlasService")
    private FilmAtlasService service;

    private FilmAtlas filmAtlas;
    private List<FilmAtlas> list;

    public FilmAtlas getFilmAtlas() {
        return filmAtlas;
    }

    public void setFilmAtlas(FilmAtlas filmAtlas) {
        this.filmAtlas = filmAtlas;
    }

    public List<FilmAtlas> getList() {
        return list;
    }

    public void setList(List<FilmAtlas> list) {
        this.list = list;
    }
    public String findFilmAtlasByCityId(){
        list = service.findFilmAtlasByFilmId(filmAtlas.getFilmInfo());
        for (FilmAtlas filmAtlas:list) {
            RelieveUtil.relieve(filmAtlas);
        }
        return "success";
    }
}
