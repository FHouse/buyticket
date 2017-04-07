package org.movie.entity;

import javax.persistence.*;

/**
 * 电影图集信息实体类
 * Created by Wkz on 2017/2/7.
 */
@Entity
@Table(name="filmatlas")
public class FilmAtlas {
    //主键
    private String filmAtlasId;
    //电影相关图片
    private String filmPicture;
    //乐观锁版本号
    private int ver;
    //关联的电影
    private FilmInfo filmInfo;

    @Id
    public String getFilmAtlasId() {
        return filmAtlasId;
    }
    public void setFilmAtlasId(String filmAtlasId) {
        this.filmAtlasId = filmAtlasId;
    }

    @Column
    public String getFilmPicture() {
        return filmPicture;
    }
    public void setFilmPicture(String filmPicture) {
        this.filmPicture = filmPicture;
    }

    @Column
    public int getVer() {
        return ver;
    }
    public void setVer(int ver) {
        this.ver = ver;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="filminfoid")
    public FilmInfo getFilmInfo() {
        return filmInfo;
    }
    public void setFilmInfo(FilmInfo filmInfo) {
        this.filmInfo = filmInfo;
    }
}
