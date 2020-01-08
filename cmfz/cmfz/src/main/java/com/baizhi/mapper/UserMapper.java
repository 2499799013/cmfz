package com.baizhi.mapper;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //start 数据从第几条开始  rows每页展示的条数
    List<User> queryAll(@Param("start") Integer start,@Param("rows") Integer rows);
    //总条数
    Integer count();

    //添加
    void insert(User user);

    //修改
     void update(User user);

    void delete(String[] id);

    Integer queryUserByTime(@Param("sex") String sex,@Param("day") Integer day);

     List<User> getCountByprovince();

     User queryId(String id);

}
