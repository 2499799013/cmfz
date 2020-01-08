package com.baizhi.service;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserService {
    //添加
    public void insert(User user);
    //修改
    void update(User user);
    //批量删除
    void delete(String[] id);
    //分页查询
    Map<String, Object> findByPage(@Param("page") Integer page,@Param("rows") Integer rows);
    //总条数
    Integer count();

    public List<User> getCountByprovince();

}
