package com.baizhi.mapper;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerMapper {
    //查所有
    public List<Banner> queryAll();
    //添加
    void insert(Banner banner);
    //修改
    void update(Banner banner);
    //批量删除
    void delete(String [] id);
    //分页查询  start 数据从第几条开始  rows每页展示的条数
    List<Banner> findByPage(@Param("start") Integer start,@Param("rows") Integer rows);
    //总条数
    Integer count();

    List<Banner> queryBannersByTime();
}
