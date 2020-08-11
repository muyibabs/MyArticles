package com.muyi.article.controller;

import com.muyi.article.service.ArticleService;
import com.muyi.model.article.Article;
import com.muyi.model.exception.BadRequestException;
import com.muyi.model.exception.ConflictException;
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
        if(artcId==null || artcId<1)
            throw new BadRequestException("100", "Invalid id");

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
        Article article1 = articleService.getArticleById(article.getArticleId());
        if(article1!=null)
            throw new NotFoundException("404", "Article not found");
        articleService.saveArticle(article);
    }

    @PutMapping
    public void updateArticle(@RequestBody @Valid Article article) {
        Article article1 = articleService.getArticleById(article.getArticleId());
        if(article1==null)
            throw new ConflictException("404", "Article already exist");
        articleService.saveArticle(article);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Integer id){
        if(id==null || id<1)
            throw new BadRequestException("100", "Invalid id");
        Article article = articleService.getArticleById(id);
        if(article==null)
            throw new NotFoundException("404","Article does not exist");
        articleService.deleteArticle(article);
    }
}
