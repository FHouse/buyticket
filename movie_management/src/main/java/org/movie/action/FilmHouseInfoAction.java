package org.movie.action;

import org.movie.entity.FilmHouseInfo;
import org.movie.exception.FilmHouseInfoException;
import org.movie.service.inf.FilmHouseInfoService;
import org.movie.util.PageBean;
import org.movie.util.RelieveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Describe
 * Created by Wkz on 2017/3/17.
 */
@Controller("filmHouseInfoAction")
@Scope("prototype")
public class FilmHouseInfoAction {
    //注入service
    @Autowired
    @Qualifier("filmHouseInfoService")
    private FilmHouseInfoService service;

    private FilmHouseInfo filmHouseInfo;
    private String message = "success";
    private PageBean pageBean;

    public FilmHouseInfo getFilmHouseInfo() {
        return filmHouseInfo;
    }

    public void setFilmHouseInfo(FilmHouseInfo filmHouseInfo) {
        this.filmHouseInfo = filmHouseInfo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    //添加影城
    public String addFilmHouseInfo(){
        if(service.add(filmHouseInfo)){
            return "success";
        }else{
            throw new FilmHouseInfoException("该影城已存在!");
        }
    }

    //删除影城(未完成)
    public String deleteFilmHouseInfo(){
        service.delete(filmHouseInfo);
        return "success";
    }

    //查询所有的影城
    public String findFilmHouseInfos(){
        pageBean = service.findFilmHouseInfos(pageBean);
        for (Object o:pageBean.getList()) {
            RelieveUtil.relieve(o);
        }
        return "success";
    }

    //根据地区信息查询该区域所有的影城
    public String findFilmHouseInfoByAreaId(){
        pageBean = service.findFilmHouseInfoByAreaId(pageBean,filmHouseInfo.getArea());
        for (Object o:pageBean.getList()) {
            RelieveUtil.relieve(o);
        }
        return "success";
    }

    //修改影城
    public String updateFilmHouseInfo(){
        try {
            service.update(filmHouseInfo);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            throw new FilmHouseInfoException("修改失败，请刷新后重试！");
        }
    }
}
