package org.movie.action;

import org.movie.entity.ExecutiveStaffType;
import org.movie.exception.ExecutiveStaffTypeException;
import org.movie.service.inf.ExecutiveStaffTypeService;
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
@Controller("executiveStaffTypeAction")
@Scope("prototype")
public class ExecutiveStaffTypeAction {

    //注入service
    @Autowired
    @Qualifier("executiveStaffTypeService")
    private ExecutiveStaffTypeService service;

    private ExecutiveStaffType type;
    private List<ExecutiveStaffType> list;

    public ExecutiveStaffType getType() {
        return type;
    }

    public void setType(ExecutiveStaffType type) {
        this.type = type;
    }

    public List<ExecutiveStaffType> getList() {
        return list;
    }

    public void setList(List<ExecutiveStaffType> list) {
        this.list = list;
    }

    //添加演职人员类型
    public String addExecutiveStaffType(){
        if(service.addExecutiveStaffType(type)){
            return "success";
        }
        throw new ExecutiveStaffTypeException("该演职人员类型已存在");
    }

    //删除演职人员类型
    public String deleteExecutiveStaffType(){
        try{
            service.deleteExecutiveStaffType(type);
            return "success";
        }catch(Exception e){
            throw new ExecutiveStaffTypeException("删除失败！");
        }
    }

    //修改演职人员类型
    public String updateExecutiveStaffType(){
        try {
            service.updateExecutiveStaffType(type);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExecutiveStaffTypeException("该数据已被修改，请刷新后重试！");
        }
    }

    ///查询所有演职人员类型
    public String findExecutiveStaffTypes(){
        list = service.findExecutiveStaffTypes();
        //解关系
        for (ExecutiveStaffType type:list) {
            RelieveUtil.relieve(type);
        }
        return "success";
    }
}
