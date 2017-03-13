package org.movie.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * 影院信息实体类
 * Created by Wkz on 2017/2/7.
 */
@Entity
@Table(name="filmhouseinfo")
public class FilmHouseInfo {
    //主键
    private String filmHouseId;
    //影院地址
    private String filmHouseAddress;
    //影院名称
    private String filmHouseName;
    //乐观锁版本号
    private int ver = 1;
    //影城所在的县（区）
    private Area area;
    //包含哪些影城用户
    private Set<FilmHouseUserInfo> filmHouseUserInfos;
    //该影院所有的影厅
    private Set<MovieHallInfo> movieHallInfos;

    @Id
    public String getFilmHouseId() {
        return filmHouseId;
    }
    public void setFilmHouseId(String filmHouseId) {
        this.filmHouseId = filmHouseId;
    }

    @Column
    public String getFilmHouseAddress() {
        return filmHouseAddress;
    }
    public void setFilmHouseAddress(String filmHouseAddress) {
        this.filmHouseAddress = filmHouseAddress;
    }

    @Column
    public String getFilmHouseName() {
        return filmHouseName;
    }
    public void setFilmHouseName(String filmHouseName) {
        this.filmHouseName = filmHouseName;
    }

    @Column
    public int getVer() {
        return ver;
    }
    public void setVer(int ver) {
        this.ver = ver;
    }

    @ManyToOne
    @JoinColumn(name="areaid")
    public Area getArea() {
        return area;
    }
    public void setArea(Area area) {
        this.area = area;
    }

    @OneToMany(mappedBy = "filmHouseInfo")
    public Set<FilmHouseUserInfo> getFilmHouseUserInfos() {
        return filmHouseUserInfos;
    }
    public void setFilmHouseUserInfos(Set<FilmHouseUserInfo> filmHouseUserInfos) {this.filmHouseUserInfos = filmHouseUserInfos;}

    @OneToMany(mappedBy = "filmHouseInfos")
    public Set<MovieHallInfo> getMovieHallInfos() {
        return movieHallInfos;
    }
    public void setMovieHallInfos(Set<MovieHallInfo> movieHallInfos) {
        this.movieHallInfos = movieHallInfos;
    }
}
