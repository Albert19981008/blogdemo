package com.example.blog.dao;

import com.example.blog.bean.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleDao {

    @Select("select * from article")
    List<Article> getAllArticles();
}
