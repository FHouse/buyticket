package org.movie.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * 电影信息实体类
 * Created by Wkz on 2017/2/7.
 */
@Entity
@Table(name="filminfo")
public class FilmInfo {
    //主键
    private String filmId;
    //电影名称
    private String filmName;
    //电影介绍
    private String filmIntroduce;
    //电影封面
    private String filmCover;
    //电影上架时间
    private Date filmReleaseTime;
    //电影评分人数
    private int filmScoreNum;
    //电影专业评分
    private double filmMajorScore;
    //电影评分
    private double filmScore;
    //电影票房
    private double filmBoxOffice;
    //电影时长
    private double filmLongTime;
    //乐观锁版本号
    private int ver;
    //电影类型
    private Set<FilmType> filmTypes;
    //电影年代
    private FilmYears filmYears;
    //电影地区
    private FilmRegion filmRegion;
    //电影上架状态
    private String filmState;

    @Id
    public String getFilmId() {
        return filmId;
    }
    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    @Column
    public String getFilmName() {
        return filmName;
    }
    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    @Column
    public String getFilmIntroduce() {
        return filmIntroduce;
    }
    public void setFilmIntroduce(String filmIntroduce) {
        this.filmIntroduce = filmIntroduce;
    }

    @Column
    public String getFilmCover() {
        return filmCover;
    }
    public void setFilmCover(String filmCover) {
        this.filmCover = filmCover;
    }

    @Column
    public Date getFilmReleaseTime() {
        return filmReleaseTime;
    }
    public void setFilmReleaseTime(Date filmReleaseTime) {
        this.filmReleaseTime = filmReleaseTime;
    }

    @Column
    public int getFilmScoreNum() {
        return filmScoreNum;
    }
    public void setFilmScoreNum(int filmScoreNum) {
        this.filmScoreNum = filmScoreNum;
    }

    @Column
    public double getFilmMajorScore() {
        return filmMajorScore;
    }
    public void setFilmMajorScore(double filmMajorScore) {
        this.filmMajorScore = filmMajorScore;
    }

    @Column
    public double getFilmScore() {
        return filmScore;
    }
    public void setFilmScore(double filmScore) {
        this.filmScore = filmScore;
    }

    @Column
    public double getFilmBoxOffice() {
        return filmBoxOffice;
    }
    public void setFilmBoxOffice(double filmBoxOffice) {
        this.filmBoxOffice = filmBoxOffice;
    }

    @Column
    public double getFilmLongTime() {
        return filmLongTime;
    }
    public void setFilmLongTime(double filmLongTime) {
        this.filmLongTime = filmLongTime;
    }

    @Column
    public int getVer() {
        return ver;
    }
    public void setVer(int ver) {
        this.ver = ver;
    }

    @ManyToMany
    @JoinTable(name="filmtype_filminfo",
            joinColumns=@JoinColumn(name="filminfoid"),
            inverseJoinColumns=@JoinColumn(name="filmtypeid"))
    public Set<FilmType> getFilmTypes() {
        return filmTypes;
    }
    public void setFilmTypes(Set<FilmType> filmTypes) {
        this.filmTypes = filmTypes;
    }

    @ManyToOne
    @JoinColumn(name="filmyearsid")
    public FilmYears getFilmYears() {
        return filmYears;
    }
    public void setFilmYears(FilmYears filmYears) {
        this.filmYears = filmYears;
    }

    @ManyToOne
    @JoinColumn(name="filmregionId")
    public FilmRegion getFilmRegion() {
        return filmRegion;
    }
    public void setFilmRegion(FilmRegion filmRegion) {
        this.filmRegion = filmRegion;
    }

    @Column
    public String getFilmState() {
        return filmState;
    }
    public void setFilmState(String filmState) {
        this.filmState = filmState;
    }
}
