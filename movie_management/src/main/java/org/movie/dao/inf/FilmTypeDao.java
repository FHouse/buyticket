package org.movie.dao.inf;

import org.movie.entity.FilmType;

/**
 * Describe
 * Created by Wkz on 2017/3/28.
 */
public interface FilmTypeDao extends BaseDao {

    /**
     * 根据类型名称查找电影类型
     * @param filmType
     * @return
     */
    public FilmType findFilmTypeByTypeName(FilmType filmType);
}
