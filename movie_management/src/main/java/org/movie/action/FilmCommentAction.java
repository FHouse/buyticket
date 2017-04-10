package org.movie.action;

import org.movie.entity.FilmComment;
import org.movie.exception.FilmCommentException;
import org.movie.service.inf.FilmCommentService;
import org.movie.util.RelieveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;

/**
 * Describe
 * Created by Wkz on 2017/4/10.
 */
@Controller("filmCommentAction")
@Scope("prototype")
public class FilmCommentAction {

    //注入service
    @Autowired
    @Qualifier("filmCommentService")
    private FilmCommentService service;

    private FilmComment filmComment;
    private List<FilmComment> list;
    private Set<FilmComment> filmComments;
    private String message = "success";

    public FilmComment getFilmComment() {
        return filmComment;
    }

    public void setFilmComment(FilmComment filmComment) {
        this.filmComment = filmComment;
    }

    public List<FilmComment> getList() {
        return list;
    }

    public void setList(List<FilmComment> list) {
        this.list = list;
    }

    public Set<FilmComment> getFilmComments() {
        return filmComments;
    }

    public void setFilmComments(Set<FilmComment> filmComments) {
        this.filmComments = filmComments;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //批量删除评论
    public String deleteFilmComment(){
        try{
            service.deleteFilmCommentService(filmComments);
            return "success";
        }catch(Exception e){
            e.printStackTrace();
            throw new FilmCommentException("删除失败！");
        }
    }

    //查询指定电影的所有评论
    public String findFilmCommentByFilmId(){
        list = service.findFilmCommentByFilmId(filmComment.getFilmInfo());
        for (FilmComment comment:list) {
            RelieveUtil.relieve(comment);
        }
        return "success";
    }
}
