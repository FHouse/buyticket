package org.movie.dao.inf;

import org.movie.entity.FilmAtlas;
import org.movie.util.PageBean;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface FilmAtlasDao extends BaseDao{

    /**
     * 根据电影id查询该电影下的所有的图集信息
     * @param pageBean
     * @param filmAtlas
     * @return
     */
    public PageBean findFilmAtlasByFilmId(PageBean pageBean,FilmAtlas filmAtlas);
}
