package org.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

/**
 * 电影地区实体类
 * Created by Wkz on 2017/2/7.
 */
@Entity
@Table(name="filmregion")
public class FilmRegion {
    //主键
    private String  filmRegionId;
    //地区名称
    private String filmRegionName;
    //地区状态
    private String filmRegionState = "禁用";
    //乐观锁版本号
    private int ver = 1;

    @Id
    public String getFilmRegionId() {
        return filmRegionId;
    }
    public void setFilmRegionId(String filmRegionId) {
        this.filmRegionId = filmRegionId;
    }

    @Column
    public String getFilmRegionName() {
        return filmRegionName;
    }
    public void setFilmRegionName(String filmRegionName) {
        this.filmRegionName = filmRegionName;
    }

    @Column
    public String getFilmRegionState() {
        return filmRegionState;
    }
    public void setFilmRegionState(String filmRegionState) {
        this.filmRegionState = filmRegionState;
    }

    @Column
    public int getVer() {
        return ver;
    }
    public void setVer(int ver) {
        this.ver = ver;
    }
}
