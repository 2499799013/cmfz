package com.baizhi.controller;

import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RequestMapping("admin")
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    //登录
    @ResponseBody
    @RequestMapping("login")
    public Map<String,Object>login(String name, String password, String enCode, HttpSession session){
        Map<String, Object> login = adminService.loginAdmin(name, password, enCode, session);
        System.out.println(login);
        return login;
    }
    //注销
    @RequestMapping("execute")
    public String execute(HttpSession session){
        session.invalidate();
        return "redirect:/login/login.jsp";
    }
}
