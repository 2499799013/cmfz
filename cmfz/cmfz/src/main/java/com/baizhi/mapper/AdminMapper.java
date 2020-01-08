package com.baizhi.mapper;

import com.baizhi.entity.Admin;
import tk.mybatis.mapper.common.Mapper;

public interface AdminMapper{
    //登录
    public Admin loginAdmin(String name);
}
