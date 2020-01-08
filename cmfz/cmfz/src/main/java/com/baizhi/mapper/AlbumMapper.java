package com.baizhi.mapper;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumMapper {
    //start 数据从第几条开始  rows每页展示的条数
    List<Album> queryAll(@Param("begin") Integer begin, @Param("rows") Integer rows);
    //总条数
    Integer count();

    //添加
    public void add(Album album);

    //修改
    public void updateStatus(Album album);

    public void updateUrl(Album album);

    public void updateCount(Album album);

    void delete(String[] id);
}
