package org.movie.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 电影年代实体类
 * Created by Wkz on 2017/2/7.
 */
@Entity
@Table(name="filmyears")
public class FilmYears {
    //主键
    private String filmYearsId;
    //年代名称
    private String filmYearsName;
    //年代状态
    private String filmYearsState = "禁用";
    //乐观锁版本号
    private int ver = 1;
    //一对多关联电影
    private Set<FilmInfo> films = new HashSet<>();

    @Id
    public String getFilmYearsId() {return filmYearsId;}
    public void setFilmYearsId(String filmYearsId) {
        this.filmYearsId = filmYearsId;
    }

    @Column
    public String getFilmYearsName() {
        return filmYearsName;
    }
    public void setFilmYearsName(String filmYearsName) {
        this.filmYearsName = filmYearsName;
    }

    @Column
    public String getFilmYearsState() {
        return filmYearsState;
    }
    public void setFilmYearsState(String filmYearsState) {
        this.filmYearsState = filmYearsState;
    }

    @Column
    public int getVer() {
        return ver;
    }
    public void setVer(int ver) {
        this.ver = ver;
    }

    @OneToMany(mappedBy = "filmYears")
    public Set<FilmInfo> getFilms() {
        return films;
    }
    public void setFilms(Set<FilmInfo> films) {
        this.films = films;
    }
}
