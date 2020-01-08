package com.example.blog.dao;

import com.example.blog.bean.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleDao {

    @Select("select * from article")
    List<Article> getAllArticles();

    @Select("select * from article where article_id = #{id}")
    Article getArticleById(@Param("id") int id);

    @Select("select * from article where title like '%${name}%'")
    List<Article> searchArticleByName(@Param("name") String name);

    @Insert("insert into article values (#{articleId}, #{userId}, #{topicId}, #{title}, #{articleText})")
    void addArticle(Article article);

    @Delete("delete from article where article_id = #{id}")
    void deleteArticle(@Param("id") Integer id);

    @Select("select max(article_id) from article")
    int getMaxId();
}
