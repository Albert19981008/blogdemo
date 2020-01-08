package com.example.blog.service.impl;

import com.example.blog.bean.Article;
import com.example.blog.bean.Topic;
import com.example.blog.bean.User;
import com.example.blog.dao.ArticleDao;
import com.example.blog.dao.TopicDao;
import com.example.blog.dao.UserDao;
import com.example.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TopicDao topicDao;

    @Override
    public List<Article> getAllArticle() {
        List<Article> articles = articleDao.getAllArticles();
        for (Article article : articles) {
            Topic topic = topicDao.getTopicById(article.getTopicId());
            User user = userDao.getUserById(article.getUserId());
            article.setTopicName(topic.getName());
            article.setUserName(user.getUsername());
        }
        return articles;
    }

    @Override
    public Article getArticleById(int id) {
        Article article =  articleDao.getArticleById(id);
        Topic topic = topicDao.getTopicById(article.getTopicId());
        User user = userDao.getUserById(article.getUserId());
        article.setTopicName(topic.getName());
        article.setUserName(user.getUsername());
        return article;
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

    @Override
    public List<Article> searchArticleByName(String name) {
        List<Article> articles = articleDao.searchArticleByName(name);
        for (Article article1 : articles) {
            Topic topic = topicDao.getTopicById(article1.getTopicId());
            User user = userDao.getUserById(article1.getUserId());
            article1.setTopicName(topic.getName());
            article1.setUserName(user.getUsername());
        }
        return articles;
    }
}
