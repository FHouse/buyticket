package org.movie.entity;

import javax.persistence.*;

/**
 * 影院用户信息实体类
 * Created by Wkz on 2017/2/7.
 */
@Entity
@Table(name="filmhouseuserinfo")
public class FilmHouseUserInfo {
    //主键
    private String filmHouseUserId;
    //用户名
    private String cinemaUserName;
    //密码
    private String cinemaUserPassword;
    //乐观锁版本号
    private int ver = 1;
    //隶属于哪个影城
    private FilmHouseInfo filmHouseInfo;

    @Id
    public String getFilmHouseUserId() {
        return filmHouseUserId;
    }
    public void setFilmHouseUserId(String filmHouseUserId) {
        this.filmHouseUserId = filmHouseUserId;
    }

    @Column
    public String getCinemaUserName() {
        return cinemaUserName;
    }
    public void setCinemaUserName(String cinemaUserName) {
        this.cinemaUserName = cinemaUserName;
    }

    @Column
    public String getCinemaUserPassword() {
        return cinemaUserPassword;
    }
    public void setCinemaUserPassword(String cinemaUserPassword) {
        this.cinemaUserPassword = cinemaUserPassword;
    }

    @Column
    public int getVer() {
        return ver;
    }
    public void setVer(int ver) {
        this.ver = ver;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="filmhouseinfoid")
    public FilmHouseInfo getFilmHouseInfo() {
        return filmHouseInfo;
    }
    public void setFilmHouseInfo(FilmHouseInfo filmHouseInfo) {
        this.filmHouseInfo = filmHouseInfo;
    }
}
