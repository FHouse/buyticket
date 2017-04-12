package org.movie.service.inf;

import org.movie.entity.FilmHouseInfo;
import org.movie.entity.FilmHouseUserInfo;
import org.movie.util.PageBean;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface FilmHouseUserInfoService{

    /**
     * 添加影城用户
     * @param filmHouseUserInfo 影城用户信息
     */
    public boolean addFilmHouseUser(FilmHouseUserInfo filmHouseUserInfo);

    /**
     *删除影城用户
     * @param filmHouseUserInfo 需要删除的影城用户信息
     */
    public void deleteFilmHouseUser(FilmHouseUserInfo filmHouseUserInfo);

    /**
     *查询所有影城用户信息
     * @return 返回所有影城用户信息集合
     */
    public PageBean findFilmHouseUsers(PageBean pageBean);

    /**
     * 修改影城用户信息
     * @param filmHouseUserInfo 需要修改的影城用户信息
     * @return 返回修改信息
     */
    public void updateFilmHouseUser(FilmHouseUserInfo filmHouseUserInfo) throws Exception;

    /**
     * 根据用户名查询指定用户的信息
     * @param filmHouseUserInfo  需要查询的影城用户的电话或用户名
     * @return 返回一个影城用户实例
     */
    public FilmHouseUserInfo filmHouseUserLogin(FilmHouseUserInfo filmHouseUserInfo);

    /**
     * 根据影城id查询该影城所有的影城用户
     * @param filmHouseInfo
     * @return
     */
    public List<FilmHouseUserInfo> findFilmHouseUserByFilmHouseId(FilmHouseInfo filmHouseInfo);
}
