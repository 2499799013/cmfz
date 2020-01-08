package com.baizhi.service;

import com.baizhi.entity.Chapter;

import java.util.Map;

public interface ChapterService {
    //查询所有
    Map<String, Object> queryAll(Integer page, Integer rows, String album_id);

    //添加
    public String add(Chapter chapter);

    public void updateUrl(Chapter chapter);

    public void del(String[] id);
}
