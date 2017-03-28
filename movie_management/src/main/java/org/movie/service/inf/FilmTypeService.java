package org.movie.service.inf;

import org.movie.entity.FilmType;

import java.util.List;

/**
 * Describe
 * Created by Wkz on 2017/3/28.
 */
public interface FilmTypeService {

    /**
     * 添加电影类型
     * @param filmType
     */
    public void addFilmType(FilmType filmType);

    /**
     * 修改电影类型
     * @param filmType
     */
    public void updateFilmType(FilmType filmType) throws Exception;

    /**
     * 查询所有的电影类型
     * @return 返回所有电影类型的一个list集合
     */
    public List<FilmType> findFilmTypes();
}
