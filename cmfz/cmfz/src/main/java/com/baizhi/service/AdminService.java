package com.baizhi.service;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface AdminService {
    public Map<String, Object> loginAdmin(String name, String password, String enCode, HttpSession session);

}
