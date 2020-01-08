package com.baizhi.mapper;

import com.baizhi.entity.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChapterMapper {
    //分页
    public List<Chapter> queryAll(@Param("begin") Integer begin,@Param("rows") Integer rows,@Param("id") String id);
    //总条数
    public Integer count(String id);
    //添加
    public void add(Chapter chapter);
    //修改
    public void updateUrl(Chapter chapter);
    //删除
    public void del(String [] id);

}
