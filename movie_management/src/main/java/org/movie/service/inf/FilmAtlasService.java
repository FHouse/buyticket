package org.movie.service.inf;

import org.movie.entity.FilmAtlas;
import org.movie.util.PageBean;

import java.util.List;
import java.util.Set;

/**
 * Created by admin on 2017/3/14.
 */
public interface FilmAtlasService{

    /**
     * 添加图集
     * @param filmAtlas
     */
    public void addFilmAtlas(FilmAtlas filmAtlas);

    /**
     * 添加多个图集
     * @param atlasSet
     */
    public void addFilmAtlas(Set<FilmAtlas> atlasSet);

    /**
     * 删除图集
     * @param filmAtlas
     */
    public void deleteFilmAtlas(FilmAtlas filmAtlas);

    /**
     * 批量删除多个图集
     * @param atlasSet
     */
    public void deleteFilmAtlas(Set<FilmAtlas> atlasSet);

    /**
     * 修改图集
     * @param filmAtlas
     */
    public void updateFilmAtlas(FilmAtlas filmAtlas) throws Exception;

    /**
     * 查询所有图集
     * @param pageBean
     * @return
     */
    public PageBean findFilmAtlases(PageBean pageBean);

    /**
     * 根据电影id查询该电影所有的图集
     * @param pageBean
     * @param filmAtlas
     * @return
     */
    public PageBean findFilmAtlasByFilmId(PageBean pageBean,FilmAtlas filmAtlas);
}
