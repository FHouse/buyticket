package org.movie.action;

import com.google.gson.Gson;
import org.movie.entity.ExecutiveStaffInfo;
import org.movie.exception.ExecutiveStaffInfoException;
import org.movie.service.inf.ExecutiveStaffInfoService;
import org.movie.util.PageBean;
import org.movie.util.RelieveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Describe
 * Created by Wkz on 2017/3/29.
 */
@Controller("executiveStaffInfoAction")
@Scope("prototype")
public class ExecutiveStaffInfoAction {

    //注入service
    @Autowired
    @Qualifier("executiveStaffInfoService")
    private ExecutiveStaffInfoService service;

    private ExecutiveStaffInfo executiveStaffInfo;
    private PageBean pageBean;

    public ExecutiveStaffInfo getExecutiveStaffInfo() {
        return executiveStaffInfo;
    }

    public void setExecutiveStaffInfo(ExecutiveStaffInfo executiveStaffInfo) {
        this.executiveStaffInfo = executiveStaffInfo;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    //添加演职人员
    public String addExecutiveStaffInfo(){
        try{
            service.addExecutiveStaffInfo(executiveStaffInfo);
            return "success";
        }catch(Exception e){
            throw new ExecutiveStaffInfoException("添加失败！");
        }
    }

    //删除演职人员
    public String deleteExecutiveStaffInfoById(){
        try{
            service.deleteExecutiveStaffInfoByID(executiveStaffInfo);
            return "success";
        }catch(Exception e){
            throw new ExecutiveStaffInfoException("删除失败！");
        }
    }

    //根据电影id删除演职人员
    public String deleteExecutiveStaffInfoByFilmId(){
        try{
            service.deleteExecutiveStaffInfoByFilmID(executiveStaffInfo.getFilmInfo().getFilmId());
            return "success";
        }catch(Exception e){
            throw new ExecutiveStaffInfoException("删除失败！");
        }
    }

    //修改演职人员
    public String updateExecutiveStaffInfo() {
        try {
            service.updateExecutiveStaffInfo(executiveStaffInfo);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExecutiveStaffInfoException("该数据已被修改，请刷新后重试！");
        }
    }

    //查询所有演职人员
    public String findExecutiveStaffInfos(){
        pageBean = service.findExecutiveStaffInfos(pageBean);
        for (Object o:pageBean.getList()) {
            RelieveUtil.relieve(o);
        }
        return "success";
    }

    //根据电影id查询该电影下的所有的演职人员信息
    public String FindExecutiveStaffInfoByFilmId(){
        pageBean = service.findExecutiveStaffInfoByFilmId(pageBean,executiveStaffInfo.getFilmInfo());
        for (Object o:pageBean.getList()) {
            RelieveUtil.relieve(o);
        }
        return "success";
    }
}
