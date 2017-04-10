package org.movie.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 影厅信息
 * Created by Wkz on 2017/2/9.
 */
@Entity
@Table(name="moviehallinfo")
public class MovieHallInfo {
    //主键
    private String movieHallInfoId;
    //影厅名
    private String movieHallName;
    //影厅位图
    private String movieHallBitMap;
    //乐观锁版本号
    private int ver = 1;
    //所在的影院
    private FilmHouseInfo filmHouseInfos;
    //一对多关联场次
    private Set<FilmScreenings> filmScreenings = new HashSet<>();

    @Id
    public String getMovieHallInfoId() {
        return movieHallInfoId;
    }
    public void setMovieHallInfoId(String movieHallInfoId) {
        this.movieHallInfoId = movieHallInfoId;
    }

    @Column
    public String getMovieHallName() {
        return movieHallName;
    }
    public void setMovieHallName(String movieHallName) {
        this.movieHallName = movieHallName;
    }

    @Column
    public String getMovieHallBitMap() {
        return movieHallBitMap;
    }
    public void setMovieHallBitMap(String movieHallBitMap) {
        this.movieHallBitMap = movieHallBitMap;
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
    public FilmHouseInfo getFilmHouseInfos() {
        return filmHouseInfos;
    }
    public void setFilmHouseInfos(FilmHouseInfo filmHouseInfos) {
        this.filmHouseInfos = filmHouseInfos;
    }

    @OneToMany(mappedBy = "movieHallInfo",fetch = FetchType.LAZY)
    public Set<FilmScreenings> getFilmScreenings() {
        return filmScreenings;
    }
    public void setFilmScreenings(Set<FilmScreenings> filmScreenings) {
        this.filmScreenings = filmScreenings;
    }
}
