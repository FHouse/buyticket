package org.movie.action;

import org.movie.entity.ExecutiveStaffType;
import org.movie.service.inf.ExecutiveStaffTypeService;
import org.movie.util.RelieveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by admin on 2017/4/5.
 */
@Controller("executiveStaffTypeAction")
@Scope("prototype")
public class ExecutiveStaffTypeAction {
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

    public String findExecutiveStaffTypes(){
        list = service.findExecutiveStaffTypes();
        for (ExecutiveStaffType executiveStaffType:list){
            RelieveUtil.relieve(executiveStaffType);
        }
        return "success";
    }
}
