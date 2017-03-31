package org.movie.action;

import org.movie.entity.ExecutiveStaffInfo;
import org.movie.service.inf.ExecutiveStaffInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by admin on 2017/3/31.
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

    public String findExecutiveStaffInfoById(){
        list = service.findExecutiveStaffInfoById(executiveStaffInfo);
        return "success";
    }
}
