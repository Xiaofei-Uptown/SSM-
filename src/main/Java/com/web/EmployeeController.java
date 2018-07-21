package com.web;

import com.Service.EmployeeService;
import com.entity.DeptAndEmp;
import com.entity.DeptNum;
import com.entity.Employee;
import com.entity.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(Employee employee){
        employeeService.saveEmp(employee);
        return Msg.success();
    }
    @RequestMapping(value="/emp/{id}",method = RequestMethod.DELETE)
    public  Msg deleteEmpById(@PathVariable("id") Integer id){
        employeeService.deleteEmp(id);
        return null;
    }

    @RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable("id") Integer id){

        Employee employee = employeeService.getEmp(id);
        return Msg.success().add("emp",employee);
    }

    @RequestMapping(value="/emp/{emp_id}",method=RequestMethod.PUT)
    @ResponseBody
    public Msg saveEmp(Employee employee,HttpServletRequest request){
//        System.out.println("请求体中的值："+request.getParameter("gender"));
//        System.out.println("将要更新的员工数据："+employee);
        employeeService.updateEmp(employee);
        return Msg.success();
    }

    @RequestMapping(value="/echarts")
    public String getpeople(){
        //List<DeptNum> list = employeeService.selectPeople();

        return "Echarts";
    }

    @RequestMapping(value="/look")
    @ResponseBody
    public Msg lookdept(){
        List<DeptNum> list = employeeService.selectPeople();
        return Msg.success().add("look",list);
    }

    @RequestMapping("/emps")
    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue = "1") Integer pn,Model model){
        PageHelper.startPage(pn,5);
        //startPage后紧跟的查询就是一个分页查询
        List<DeptAndEmp> deptAndemps = employeeService.getAll();

        //使用pageinfo包装查询结果，将pageinfo交给页面
        //封装了详细的分页信息，包括查询出来的数据,连续传入显示的页数
        PageInfo page = new PageInfo(deptAndemps,5);
        return Msg.success().add("pageInfo",page);
    }

   // @RequestMapping(value = "/emps")
    public String getEmps(@RequestParam(value="pn",defaultValue = "1") Integer pn,Model model){
       //引入封页插件

       //查询之前只需要调用,传入每页的大小
       PageHelper.startPage(pn,5);
       //startPage后紧跟的查询就是一个分页查询
        List<DeptAndEmp> deptAndemps = employeeService.getAll();

        //使用pageinfo包装查询结果，将pageinfo交给页面
       //封装了详细的分页信息，包括查询出来的数据,连续传入显示的页数
        PageInfo page = new PageInfo(deptAndemps,5);
  //      System.out.println(page.getList());
        model.addAttribute("pageInfo",page);
        return "list";
    }
}
