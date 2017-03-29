package org.movie.action;

import org.movie.entity.ExecutiveStaffInfo;
import org.movie.exception.ExecutiveStaffInfoException;
import org.movie.service.inf.ExecutiveStaffInfoService;
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
    private List<ExecutiveStaffInfo> list;

    public ExecutiveStaffInfo getExecutiveStaffInfo() {
        return executiveStaffInfo;
    }

    public void setExecutiveStaffInfo(ExecutiveStaffInfo executiveStaffInfo) {
        this.executiveStaffInfo = executiveStaffInfo;
    }

    public List<ExecutiveStaffInfo> getList() {
        return list;
    }

    public void setList(List<ExecutiveStaffInfo> list) {
        this.list = list;
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
        list = service.findExecutiveStaffInfos();
        return "success";
    }
}
