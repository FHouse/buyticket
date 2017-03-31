package org.movie.action;

import com.opensymphony.xwork2.ActionContext;
import org.movie.entity.FilmHouseUserInfo;
import org.movie.exception.FilmHouseInfoException;
import org.movie.exception.FilmHouseUserInfoException;
import org.movie.service.inf.FilmHouseUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * 影城用户的控制类
 * Created by Wkz on 2017/3/23.
 */
@Controller("filmHouseUserInfoAction")
@Scope("prototype")
public class FilmHouseUserInfoAction {

    //注入service
    @Autowired
    @Qualifier("filmHouseUserInfoService")
    private FilmHouseUserInfoService service;

    private FilmHouseUserInfo filmHouseUserInfo;
    private String message;
    private List<FilmHouseUserInfo> list;

    public FilmHouseUserInfo getFilmHouseUserInfo() {
        return filmHouseUserInfo;
    }
    public void setFilmHouseUserInfo(FilmHouseUserInfo filmHouseUserInfo) {
        this.filmHouseUserInfo = filmHouseUserInfo;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public List<FilmHouseUserInfo> getList() {
        return list;
    }
    public void setList(List<FilmHouseUserInfo> list) {
        this.list = list;
    }

    //添加影城用户
    public String addFilmHouseUser(){
        if(service.addFilmHouseUser(filmHouseUserInfo)){
            return "success";
        }else{
            throw new FilmHouseInfoException("该影城用户已存在！");
        }

    }

    //删除影城用户
    public String deleteFilmHouseUser(){
        service.deleteFilmHouseUser(filmHouseUserInfo);
        return "success";
    }

    //修改影城用户
    public String updateFilmHouseUser(){
        try {
            service.updateFilmHouseUser(filmHouseUserInfo);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            throw new FilmHouseUserInfoException("修改失败，请刷新后重试！");
        }
    }

    //查询所有影城用户
    public String findFilmHouseUsers(){
        list = service.findFilmHouseUsers();
        return "success";
    }

    //影城用户登陆
    public String filmHouseUserLogin(){
        try{
            FilmHouseUserInfo filmHouseUserInfo1 = service.filmHouseUserLogin(filmHouseUserInfo);
            if(filmHouseUserInfo1.getCinemaUserName().equals(filmHouseUserInfo.getCinemaUserName())){
                ActionContext.getContext().getSession().put("filmHouseUserName",filmHouseUserInfo1.getCinemaUserName());
                return "success";
            }else{
                throw new FilmHouseUserInfoException("用户名或密码错误！");
            }
        }catch(Exception e){
            throw new FilmHouseUserInfoException("用户名或密码错误！");
        }
    }

    //根据影城id查询影城下所有用户信息
    public String findFilmHouseUserByFilmHouseId(){
        list = service.findFilmHouseUserByFilmHouseId(filmHouseUserInfo.getFilmHouseInfo());
        return "success";
    }
}
