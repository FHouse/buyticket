package org.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 普通用户实体类
 * Created by Wkz on 2017/2/9.
 */
@Entity
@Table(name="users")
public class Users {
    //主键
    private String usersId;
    //用户名
    private String userName;
    //密码
    private String userPassword;
    //手机号
    private String userTel;
    //乐观锁版本号
    private int ver = 1;

    @Id
    public String getUsersId() {
        return usersId;
    }
    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }

    @Column
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Column
    public String getUserTel() {
        return userTel;
    }
    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    @Column
    public int getVer() {
        return ver;
    }
    public void setVer(int ver) {
        this.ver = ver;
    }
}
