package org.movie.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 电影场次
 * Created by Wkz on 2017/2/9.
 */
@Entity
@Table(name="filmscreenings")
public class FilmScreenings {
    //主键
    private String filmScreeningsId;
    //播放时间
    private Date filmPlayTime;
    //价格
    private Double filmPrice;
    //所在的影厅
    private MovieHallInfo movieHallInfo;
    //播放的电影
    private FilmInfo filmInfo;
    //一对多关联订单
    private Set<OrderInfo> orders = new HashSet<>();

    @Id
    public String getFilmScreeningsId() {
        return filmScreeningsId;
    }
    public void setFilmScreeningsId(String filmScreeningsId) {
        this.filmScreeningsId = filmScreeningsId;
    }

    @Column
    public Date getFilmPlayTime() {
        return filmPlayTime;
    }
    public void setFilmPlayTime(Date filmPlayTime) {
        this.filmPlayTime = filmPlayTime;
    }

    @Column
    public Double getFilmPrice() {
        return filmPrice;
    }
    public void setFilmPrice(Double filmPrice) {
        this.filmPrice = filmPrice;
    }

    @ManyToOne
    @JoinColumn(name="moviehallinfoid")
    public MovieHallInfo getMovieHallInfo() {
        return movieHallInfo;
    }
    public void setMovieHallInfo(MovieHallInfo movieHallInfo) {
        this.movieHallInfo = movieHallInfo;
    }

    @ManyToOne
    @JoinColumn(name="filminfoid")
    public FilmInfo getFilmInfo() {
        return filmInfo;
    }
    public void setFilmInfo(FilmInfo filmInfo) {
        this.filmInfo = filmInfo;
    }

    @OneToMany(mappedBy = "filmScreenings")
    public Set<OrderInfo> getOrders() {
        return orders;
    }
    public void setOrders(Set<OrderInfo> orders) {
        this.orders = orders;
    }
}
