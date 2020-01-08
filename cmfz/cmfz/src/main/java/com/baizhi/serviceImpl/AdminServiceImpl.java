package com.baizhi.serviceImpl;

import com.baizhi.entity.Admin;
import com.baizhi.mapper.AdminMapper;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String, Object> loginAdmin(String name, String password, String enCode, HttpSession session) {
        HashMap<String, Object> map = new HashMap<>();
        String code1 = (String) session.getAttribute("Code");
        if (code1.equals(enCode)){
            Admin admin = adminMapper.loginAdmin(name);
            if (admin !=null){
                if (password.equals(admin.getPassword())){
                    map.put("msg","ok");
                    return map;
                }else {
                    map.put("msg","您输入的密码错误，请重新输入！");
                    return map;
                }
            }else {
                map.put("msg","此用户不存在");
                return map;
            }
        }else {
            map.put("msg","验证码错误");
            return map;
        }
    }
}
