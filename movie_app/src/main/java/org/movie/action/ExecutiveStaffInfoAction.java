package org.movie.action;

import org.movie.entity.ExecutiveStaffInfo;
import org.movie.service.inf.ExecutiveStaffInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by admin on 2017/4/5.
 */
@Controller("executiveStaffInfoAction")
@Scope("prototype")
public class ExecutiveStaffInfoAction {

    @Autowired
    @Qualifier("executiveStaffInfoService")
    private ExecutiveStaffInfoService service;

    private List<ExecutiveStaffInfo> list;

    public List<ExecutiveStaffInfo> getList() {
        return list;
    }

    public void setList(List<ExecutiveStaffInfo> list) {
        this.list = list;
    }

    public String findExecutiveStaffInfos(){
        list = service.findExecutiveStaffInfos();
        return "success";
    }
}
