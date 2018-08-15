package com.web;


import com.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/")
    public String welcome(){

        return "login";
    }

    @RequestMapping(value="login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,Map<String,Object> map,
                        HttpSession session){


        if(!"".equals(username)&&password.equals("123")){
            session.setAttribute("loginname",username);
            return "index";
        }else{
            return "login";
        }

    }

}
