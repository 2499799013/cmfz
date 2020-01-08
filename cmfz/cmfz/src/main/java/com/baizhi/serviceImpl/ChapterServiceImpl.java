package com.baizhi.serviceImpl;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.mapper.AlbumMapper;
import com.baizhi.mapper.ChapterMapper;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    ChapterMapper chapterMapper;
    @Autowired
    AlbumMapper albumMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String, Object> queryAll(Integer page, Integer rows, String id) {
        Map<String, Object> map = new HashMap<>();
        //获取数据库中的起始条
        Integer begin = (page - 1) * rows;
        //查询出章节列表
        List<Chapter> list = chapterMapper.queryAll(begin, rows, id);
        //查询出总条数
        Integer records = chapterMapper.count(id);
        //总页数
        Integer total = records % rows == 0 ? records / rows : records / rows + 1;
        map.put("total", total);
        map.put("records", records);
        map.put("page", page);
        map.put("rows", list);
        //总页数  total
        //当前页  page
        //章节列表 rows
        //总条数   records

        return map;
    }

    @Override
    public String add(Chapter chapter) {
        String s = UUID.randomUUID().toString();
        chapter.setId(s);
        chapter.setCreateDate(new Date());
        chapter.setLongTime("sdf");
        chapter.setSize("sss");
        chapterMapper.add(chapter);
        return s;
    }

    @Override
    public void updateUrl(Chapter chapter) {
        chapterMapper.updateUrl(chapter);
        Integer count = chapterMapper.count(chapter.getAlbumId());
        Album album = new Album();
        album.setCount(count);
        album.setId(chapter.getAlbumId());
        albumMapper.updateCount(album);
    }

    @Override
    public void del(String[] id) {
        chapterMapper.del(id);
    }
}
