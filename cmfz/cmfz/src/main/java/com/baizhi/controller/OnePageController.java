package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Article;
import com.baizhi.entity.Banner;
import com.baizhi.mapper.AlbumMapper;
import com.baizhi.mapper.ArticleMapper;
import com.baizhi.mapper.BannerMapper;
import com.baizhi.mapper.ChapterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("onPage")
@RestController
public class OnePageController {
    @Autowired
    BannerMapper bannerMapper;
    @Autowired
    AlbumMapper albumMapper;
    @Autowired
    ArticleMapper articleMapper;

    @RequestMapping("onePage")
    // type : all|wen|si
    public Map onePage(String uid,String type,String sub_type){
        HashMap hashMap = new HashMap();
            if (type.equals("all")){
                List<Banner> banners = bannerMapper.queryBannersByTime();
                List<Album> albums = albumMapper.queryAll(0,5);
                List<Article> articles = articleMapper.queryAll(0,5);
                hashMap.put("status",200);
                hashMap.put("head",banners);
                hashMap.put("albums",albums);
                hashMap.put("articles",articles);
            }else if (type.equals("wen")){
                List<Album> albums = albumMapper.queryAll(0,5);
                hashMap.put("status",200);
                hashMap.put("albums",albums);
            }else {
                if (sub_type.equals("ssyj")){
                    List<Article> articles = articleMapper.queryAll(0,5);
                    hashMap.put("status",200);
                    hashMap.put("articles",articles);
                }else {
                    List<Article> articles = articleMapper.queryAll(0,5);
                    hashMap.put("status",200);
                    hashMap.put("articles",articles);
                }
            }
        return hashMap;
    }



}
