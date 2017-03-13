package org.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 演职人员类型实体类
 * Created by Wkz on 2017/2/9.
 */
@Entity
@Table(name="executivestafftype")
public class ExecutiveStaffType {
    //主键
    private String executiveStaffTypeId;
    //类型名称
    private String typeName;
    //乐观锁版本号
    private int ver = 1;

    @Id
    public String getExecutiveStaffTypeId() {
        return executiveStaffTypeId;
    }
    public void setExecutiveStaffTypeId(String executiveStaffTypeId) {
        this.executiveStaffTypeId = executiveStaffTypeId;
    }

    @Column
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Column
    public int getVer() {
        return ver;
    }
    public void setVer(int ver) {
        this.ver = ver;
    }
}
