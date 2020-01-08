package com.baizhi.serviceImpl;

import com.baizhi.entity.Album;
import com.baizhi.mapper.AlbumMapper;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    AlbumMapper albumMapper;
    @Override
    public Map<String, Object> queryAll(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        //获取数据库中的起始条数
        Integer begin = (page - 1) * rows;
        List<Album> list = albumMapper.queryAll(begin, rows);
        //查询出总条数
        Integer records = albumMapper.count();
        //总页数
        //总条数%每页展示的条数
        Integer total = records % rows == 0 ? records / rows : records / rows + 1;
        map.put("total", total);
        map.put("records", records);
        map.put("page", "page");
        map.put("rows", list);
        //总页数 total
        //当前页  page
        //轮播图列表  rows
        //总条数  records
        return map;
    }

    @Override
    public String add(Album album) {
        String s = UUID.randomUUID().toString();
        album.setId(s);
        album.setPublishDate(new Date());
        albumMapper.add(album);
        return s;
    }

    @Override
    public void updateUrl(Album album) {
        albumMapper.updateUrl(album);

    }

    @Override
    public void updateStatus(Album album) {
        albumMapper.updateStatus(album);
    }

    @Override
    public void delete(String[] id) {
        albumMapper.delete(id);
    }
}
