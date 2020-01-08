package com.baizhi.service;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface AlbumService {
    //查询所有
    Map<String, Object> queryAll(@Param("begin") Integer begin, @Param("rows") Integer rows);

    //添加
    public String add(Album album);

    //修改
    public void updateUrl(Album album);

    public void updateStatus(Album album);


    void delete(String[] id);

}
