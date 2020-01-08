package com.baizhi.service;

import com.baizhi.entity.Article;

import java.util.List;
import java.util.Map;

public interface ArticleService {
    public Map<String, Object> queryAll(Integer page, Integer rows);

    String add(Article article);

    void update(Article article);

    public List<Article> queryByes(String val);

    void delete(String[] id);
}
