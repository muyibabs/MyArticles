package com.muyi.article.controller;

import com.muyi.article.service.ArticleService;
import com.muyi.model.article.Article;
import com.muyi.model.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {

    ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable(name = "id") Integer artcId) {
        Article article = articleService.getArticleById(artcId);
        if(article==null)
            throw new NotFoundException("101", "Article with id: "+ artcId + " not found");
        return article;
    }

    @GetMapping
    public List<Article> getArticles() {
        System.out.println("----------------------------------- getArticles method");
        return articleService.getAllArticles();
    }

    @PostMapping
    public void createArticle(@RequestBody @Valid Article article) {
        articleService.saveArticle(article);
    }

    @PutMapping
    public void updateArticle(@RequestBody @Valid Article article) {
        articleService.saveArticle(article);
    }
}
