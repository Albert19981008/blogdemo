package com.example.blog.service;

import com.example.blog.bean.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getAllArticle();

    Article getArticleById(int id);

    boolean addArticle(Article article);

    boolean deleteArticle(Integer id);

    List<Article> searchArticleByName(String name);
}
