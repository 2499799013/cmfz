package com.baizhi.service;

import com.baizhi.entity.Banner;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface BannerService {
    //查询所有
   public List<Banner> queryAll(HttpServletResponse response) throws Exception;

    //添加
    public void insert(Banner banner);
    //修改
    void update(Banner banner);
    //批量删除
    void delete(String[] id);
    //分页查询
    Map<String, Object> findByPage(Integer page, Integer rows);
    //总条数
    Integer count();
}
