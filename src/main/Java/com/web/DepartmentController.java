package com.web;

import com.Service.DepartmentService;
import com.entity.Department;
import com.entity.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 处理和部门有关的请求
 */
@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepys(){
        List<Department> list =  departmentService.selectDepts();
        return Msg.success().add("depts",list);
    }


}
