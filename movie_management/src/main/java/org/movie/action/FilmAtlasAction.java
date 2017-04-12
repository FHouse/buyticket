package org.movie.action;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.movie.entity.FilmAtlas;
import org.movie.exception.FilmAtlasException;
import org.movie.service.inf.FilmAtlasService;
import org.movie.util.PageBean;
import org.movie.util.RelieveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Describe
 * Created by Wkz on 2017/4/7.
 */
@Controller("filmAtlasAction")
@Scope("prototype")
public class FilmAtlasAction {

    //注入service
    @Autowired
    @Qualifier("filmAtlasService")
    private FilmAtlasService service;

    private FilmAtlas filmAtlas;
    private PageBean pageBean;
    private String message = "success";
    private Set<FilmAtlas> filmAtlases;
    //表单文件，必须是一个File类型
    private File[] uploadFile;
    //上传的文件名，格式必须是File名称加上FileName
    private String[] uploadFileFileName;
    //文件的文件类型，格式必须是File名称+ContentType
    private String[] uploadFileContentType;

    public FilmAtlas getFilmAtlas() {
        return filmAtlas;
    }

    public void setFilmAtlas(FilmAtlas filmAtlas) {
        this.filmAtlas = filmAtlas;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Set<FilmAtlas> getFilmAtlases() {
        return filmAtlases;
    }

    public void setFilmAtlases(Set<FilmAtlas> filmAtlases) {
        this.filmAtlases = filmAtlases;
    }

    public File[] getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(File[] uploadFile) {
        this.uploadFile = uploadFile;
    }

    public String[] getUploadFileFileName() {
        return uploadFileFileName;
    }

    public void setUploadFileFileName(String[] uploadFileFileName) {
        this.uploadFileFileName = uploadFileFileName;
    }

    public String[] getUploadFileContentType() {
        return uploadFileContentType;
    }

    public void setUploadFileContentType(String[] uploadFileContentType) {
        this.uploadFileContentType = uploadFileContentType;
    }

    //批量添加图集
    public String addFilmAtlases() throws IOException {
        Set<FilmAtlas> set = new HashSet<>();
        //获取上传的路径
        String uploadPath = ServletActionContext.getServletContext().getRealPath("/files");
        for (int i = 0;i<uploadFile.length;i++) {
            //如果提交过来的file不为空才执行上传操作
            if(uploadFile[i] != null){
                //根据文件名以及上传的路径构建一个新的file对象
                File saveFile = new File(uploadPath,uploadFileFileName[i]);
                //判断上传的目录是否存在，如果不存在则创建出来
                if(!saveFile.getParentFile().exists()){
                    saveFile.getParentFile().mkdirs();
                }
                //使用文件复制执行上传
                FileUtils.copyFile(uploadFile[i],saveFile);
                FilmAtlas atlas = new FilmAtlas();
                atlas.setFilmInfo(filmAtlas.getFilmInfo());
                atlas.setFilmPicture(uploadPath+"\\"+uploadFileFileName);
                set.add(atlas);
            }
        }

        try{
            service.addFilmAtlas(set);
            return "success";
        }catch (Exception e){
            throw new FilmAtlasException("添加失败");
        }

    }

    //批量删除图集
    public String deleteFilmAtlases(){
        try{
            service.deleteFilmAtlas(filmAtlases);
            return "success";
        }catch(Exception e){
            throw new FilmAtlasException("删除失败!");
        }
    }

    //修改图集
    public String updateFilmAtlas(){
        try{
            service.updateFilmAtlas(filmAtlas);
            return "success";
        }catch(Exception e){
            throw new FilmAtlasException("修改失败,请刷新后重试！");
        }
    }

    //查询所有图集
    public String findFilmAtlases(){
        pageBean = service.findFilmAtlases(pageBean);
        for (Object o:pageBean.getList()) {
            RelieveUtil.relieve(o);
        }
        return "success";
    }

    //根据电影id查询该电影的所有图集
    public String findFilmAtlasByFilmId(){
        pageBean = service.findFilmAtlasByFilmId(pageBean,filmAtlas);
        for (Object o: pageBean.getList()) {
            RelieveUtil.relieve(o);
        }
        return "success";
    }
}
