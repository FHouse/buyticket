package org.movie.entity;

import javax.persistence.*;

/**
 * 县（区）级单位实体类
 * Created by Wkz on 2017/2/14.
 */
@Entity
@Table(name = "area")
public class Area {
    //主键
    private String areaId;
    //县（区）级单位名称
    private String areaName;
    //乐观锁版本号
    private int ver = 1;
    //所在的市
    private City city;

    @Id
    public String getAreaId() {
        return areaId;
    }
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    @Column
    public String getAreaName() {
        return areaName;
    }
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Column
    public int getVer() {
        return ver;
    }
    public void setVer(int ver) {
        this.ver = ver;
    }

    @ManyToOne
    @JoinColumn(name = "cityId")
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }
}
