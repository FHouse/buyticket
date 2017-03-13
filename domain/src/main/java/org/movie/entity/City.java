package org.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 市级单位实体类
 * Created by Wkz on 2017/2/14.
 */
@Entity
@Table(name = "city")
public class City {
    //主键
    private String cityId;
    //市级单位名称
    private String cityName;
    //乐观锁版本号
    private int ver = 1;

    @Id
    public String getCityId() {return cityId;}
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Column
    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Column
    public int getVer() {
        return ver;
    }
    public void setVer(int ver) {
        this.ver = ver;
    }
}
