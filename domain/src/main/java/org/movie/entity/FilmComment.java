package org.movie.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * 电影评论记录
 * Created by Wkz on 2017/2/9.
 */
@Entity
@Table(name="filmcomment")
public class FilmComment {
    //主键
    private String filmCommentId;
    //评论内容
    private String commentContent;
    //评论时间
    private Date commentTime;
    //评论的人
    private Users users;
    //评论的电影
    private FilmInfo filmInfo;

    @Id
    public String getFilmCommentId() {
        return filmCommentId;
    }
    public void setFilmCommentId(String filmCommentId) {
        this.filmCommentId = filmCommentId;
    }

    @Column
    public String getCommentContent() {
        return commentContent;
    }
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Column
    public Date getCommentTime() {
        return commentTime;
    }
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    @ManyToOne
    @JoinColumn(name="usersid")
    public Users getUsers() {
        return users;
    }
    public void setUsers(Users users) {
        this.users = users;
    }

    @ManyToOne
    @JoinColumn(name="filminfoid")
    public FilmInfo getFilmInfo() {
        return filmInfo;
    }
    public void setFilmInfo(FilmInfo filmInfo) {
        this.filmInfo = filmInfo;
    }
}
