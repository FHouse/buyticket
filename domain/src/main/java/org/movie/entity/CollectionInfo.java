package org.movie.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * 想看记录实体类
 * Created by Wkz on 2017/2/9.
 */
@Entity
@Table(name="collectioninfo")
public class CollectionInfo {
    //主键
    private String collectionInfoId;
    //想看记录的时间
    private Date recordTime;
    //想看的电影
    private FilmInfo filmInfo;
    //想看的人
    private Users users;

    @Id
    public String getCollectionInfoId() {
        return collectionInfoId;
    }
    public void setCollectionInfoId(String collectionInfoId) {
        this.collectionInfoId = collectionInfoId;
    }

    @Column
    public Date getRecordTime() {
        return recordTime;
    }
    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="filminfoid")
    public FilmInfo getFilmInfo() {
        return filmInfo;
    }
    public void setFilmInfo(FilmInfo filmInfo) {
        this.filmInfo = filmInfo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usersid")
    public Users getUsers() {
        return users;
    }
    public void setUsers(Users users) {
        this.users = users;
    }
}
