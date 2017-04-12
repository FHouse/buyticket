package org.movie.action;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.movie.entity.FilmInfo;
import org.movie.exception.FilmInfoException;
import org.movie.service.inf.FilmInfoService;
import org.movie.util.PageBean;
import org.movie.util.RelieveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Describe
 * Created by Wkz on 2017/3/31.
 */
@Controller("filmInfoAction")
@Scope("prototype")
public class FilmInfoAction {

    //注入service
    @Autowired
    @Qualifier("filmInfoService")
    private FilmInfoService service;

    private FilmInfo filmInfo;
    private PageBean pageBean;
    //表单文件,必须是一个File类型
    private File uploadFile;
    //上传的文件名,格式必须是File名称 + FileName
    private String uploadFileFileName;
    //上传的文件类型,格式必须是File名称 + ContentType
    private String uploadFileContentType;
    private String message = "success";

    public FilmInfo getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(FilmInfo filmInfo) {
        this.filmInfo = filmInfo;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public File getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(File uploadFile) {
        this.uploadFile = uploadFile;
    }

    public String getUploadFileFileName() {
        return uploadFileFileName;
    }

    public void setUploadFileFileName(String uploadFileFileName) {
        this.uploadFileFileName = uploadFileFileName;
    }

    public String getUploadFileContentType() {
        return uploadFileContentType;
    }

    public void setUploadFileContentType(String uploadFileContentType) {
        this.uploadFileContentType = uploadFileContentType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //添加电影信息
    public String addFilmInfo() throws IOException {
        //获取上传的绝对路径
        String uploadPath = ServletActionContext.getServletContext().getRealPath("/files");
        //如果提交过来的File不为null，才执行上传操作
        if(uploadFile != null){
            //根据文件名以及上传的路径构建一个新的File对象
            File saveFile = new File(uploadPath, uploadFileFileName);
            //先判断上传的目录是否存在，如果不存在则创建出来
            if(!saveFile.getParentFile().exists()){
                saveFile.getParentFile().mkdirs();
            }
            //使用文件复制执行上传
            FileUtils.copyFile(uploadFile, saveFile);
        }

        String filePath = ""+uploadPath+"\\"+uploadFileFileName+"";
        System.out.println(filePath);
        filmInfo.setFilmCover(uploadPath);

        if(service.addFilmInfo(filmInfo)){
            return "success";
        }else{
            throw new FilmInfoException("添加失败！");
        }
    }

    //修改电影信息
    public String updateFilmInfo(){
        try{
            service.updateFilmInfo(filmInfo);
            return "success";
        }catch(Exception e){
            e.printStackTrace();
            throw new FilmInfoException("修改失败，请刷新后重试！");
        }
    }

    //根据电影id查询电影信息
    public String findFilmInfoById(){
        filmInfo = service.findFilmInfoById(filmInfo);
        RelieveUtil.relieve(filmInfo);
        return "success";
    }

    //查询所有电影信息
    public String findFilmInfos(){
        pageBean = service.findFilmInfos(pageBean);
        for (Object o:pageBean.getList()) {
            RelieveUtil.relieve(o);
        }
        return "success";
    }
}
