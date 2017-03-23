package org.movie.dao.inf;

import org.movie.entity.FilmHouseInfo;
import org.movie.entity.FilmHouseUserInfo;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface FilmHouseUserInfoDao extends BaseDao{

    /**
     * 根据影城用户名查询影城用户信息
     * @param filmHouseUserInfo 影城用户的封装对象
     * @return 返回该用户名所对应的影城用户信息
     */
    public FilmHouseUserInfo findFilmHouseUserByName(FilmHouseUserInfo filmHouseUserInfo);

    /**
     * 根据影城id查询该影城所有的用户
     * @param filmHouseInfo 需要查询的影城的信息
     * @return 返回自定影城的用户的集合
     */
    public List<FilmHouseUserInfo> findFilmHouseUsersByFilmHouseId(FilmHouseInfo filmHouseInfo);
}
