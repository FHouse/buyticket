package org.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 业务人员实体类
 * Created by Wkz on 2017/2/9.
 */
@Entity
@Table(name = "admin")
public class Admin {
    //主键
    private String adminId;
    //用户名
    private String adminName;
    //密码
    private String adminPassword;
    //乐观锁版本号
    private int ver = 1;

    @Id
    public String getAdminId() {
        return adminId;
    }
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    @Column
    public String getAdminName() {
        return adminName;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Column
    public String getAdminPassword() {
        return adminPassword;
    }
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Column
    public int getVer() {
        return ver;
    }
    public void setVer(int ver) {
        this.ver = ver;
    }
}
