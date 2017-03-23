package org.movie.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    //一对多关联想看记录
    private Set<CollectionInfo> collections = new HashSet<>();
    //一对多关联评论信息
    private Set<FilmComment> filmComments = new HashSet<>();
    //一对多关联订单
    private Set<OrderInfo> orders = new HashSet<>();

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

    @OneToMany(mappedBy = "users")
    public Set<CollectionInfo> getCollections() {
        return collections;
    }
    public void setCollections(Set<CollectionInfo> collections) {
        this.collections = collections;
    }

    @OneToMany(mappedBy = "users")
    public Set<FilmComment> getFilmComments() {
        return filmComments;
    }
    public void setFilmComments(Set<FilmComment> filmComments) {
        this.filmComments = filmComments;
    }

    @OneToMany(mappedBy = "users")
    public Set<OrderInfo> getOrders() {
        return orders;
    }
    public void setOrders(Set<OrderInfo> orders) {
        this.orders = orders;
    }
}
