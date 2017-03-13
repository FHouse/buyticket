package org.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

/**
 * 电影类型实体类
 * Created by Wkz on 2017/2/7.
 */
@Entity
@Table(name="filmtype")
public class FilmType {
    //主键
    private String filmTypeId;
    //类型名称
    private String filmTypeName;
    //类型状态
    private String filmTypeState = "禁用";
    //乐观锁版本号
    private int ver = 1;

    @Id
    public String getFilmTypeId() {
        return filmTypeId;
    }
    public void setFilmTypeId(String filmTypeId) {
        this.filmTypeId = filmTypeId;
    }

    @Column
    public String getFilmTypeName() {
        return filmTypeName;
    }
    public void setFilmTypeName(String filmTypeName) {
        this.filmTypeName = filmTypeName;
    }

    @Column
    public String getFilmTypeState() {
        return filmTypeState;
    }
    public void setFilmTypeState(String filmTypeState) {
        this.filmTypeState = filmTypeState;
    }

    @Column
    public int getVer() {
        return ver;
    }
    public void setVer(int ver) {
        this.ver = ver;
    }
}
