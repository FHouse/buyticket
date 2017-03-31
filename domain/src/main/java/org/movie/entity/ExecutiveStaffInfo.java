package org.movie.entity;

import net.bytebuddy.dynamic.TypeResolutionStrategy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 演职人员信息实体类
 * Created by Wkz on 2017/2/9.
 */
@Entity
@Table(name="executivestaffinfo")
public class ExecutiveStaffInfo {
    //主键
    private String executiveStaffInfoId;
    //演员姓名
    private String performerName;
    //演员照片
    private String performerPhoto;
    //乐观锁版本号
    private int ver = 1;
    //演职人员类型
    private Set<ExecutiveStaffType> executiveStaffTypes;
    //该演职人员所演出的电影
    private FilmInfo filmInfo;

    @Id
    public String getExecutiveStaffInfoId() {
        return executiveStaffInfoId;
    }
    public void setExecutiveStaffInfoId(String executiveStaffInfoId) {
        this.executiveStaffInfoId = executiveStaffInfoId;
    }

    @Column
    public String getPerformerName() {
        return performerName;
    }
    public void setPerformerName(String performerName) {
        this.performerName = performerName;
    }

    @Column
    public String getPerformerPhoto() {
        return performerPhoto;
    }
    public void setPerformerPhoto(String performerPhoto) {
        this.performerPhoto = performerPhoto;
    }

    @Column
    public int getVer() {
        return ver;
    }
    public void setVer(int ver) {
        this.ver = ver;
    }

    @ManyToMany
    @JoinTable(name="stafftype_staffinfo",
            joinColumns=@JoinColumn(name="staffinfoid"),
            inverseJoinColumns=@JoinColumn(name="stafftypeid"))
    public Set<ExecutiveStaffType> getExecutiveStaffTypes() {
        return executiveStaffTypes;
    }
    public void setExecutiveStaffTypes(Set<ExecutiveStaffType> executiveStaffTypes) {this.executiveStaffTypes = executiveStaffTypes;}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="filminfoid")
    public FilmInfo getFilmInfo() {
        return filmInfo;
    }
    public void setFilmInfo(FilmInfo filmInfo) {
        this.filmInfo = filmInfo;
    }
}
