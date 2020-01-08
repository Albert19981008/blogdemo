package com.example.blog.service.impl;

import com.example.blog.bean.Article;
import com.example.blog.dao.ArticleDao;
import com.example.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> getAllArticle() {
        return articleDao.getAllArticles();
    }

    @Override
    public boolean addArticle(Article article) {
        try {
            int id = articleDao.getMaxId() + 1;
            article.setArticleId(id);
            articleDao.addArticle(article);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteArticle(Integer id) {
        try {
            articleDao.deleteArticle(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
