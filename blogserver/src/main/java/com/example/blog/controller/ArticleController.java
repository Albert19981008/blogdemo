package com.example.blog.controller;

import com.example.blog.bean.Article;
import com.example.blog.common.ResultCode;
import com.example.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/all")
    public List<Article> getAllArticles() {
        return articleService.getAllArticle();
    }

    @GetMapping("/search/name")
    public List<Article> searchArticles(String name) {
        return articleService.searchArticleByName(name);
    }

    @PostMapping("/add")
    public ResultCode addArticle(Article article) {
        if (articleService.addArticle(article)) {
            return ResultCode.SUCCESS;
        } else {
            return ResultCode.FAILED;
        }
    }

    @PostMapping("/delete")
    public ResultCode deleteArticle(Integer id) {
        if (articleService.deleteArticle(id)) {
            return ResultCode.SUCCESS;
        } else {
            return ResultCode.FAILED;
        }
    }
}
