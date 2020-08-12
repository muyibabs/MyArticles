package com.muyi.article.controller;

import com.muyi.article.model.ArticleResponse;
import com.muyi.article.model.DetailedArticleResponseImpl;
import com.muyi.article.model.SimpleArticleResponseImpl;
import com.muyi.article.service.ArticleService;
import com.muyi.model.article.Article;
import com.muyi.model.exception.BadRequestException;
import com.muyi.model.exception.ConflictException;
import com.muyi.model.exception.NotFoundException;
import com.muyi.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {

    ArticleService articleService;
    RestTemplate restTemplate;

    @Autowired
    public ArticleController(ArticleService articleService, RestTemplate restTemplate) {
        this.articleService = articleService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{id}")
    public ArticleResponse getArticleById(@PathVariable(name = "id") Integer artcId, @RequestParam(required = false) String load) {
        if(artcId==null || artcId<1)
            throw new BadRequestException("100", "Invalid id");

        Article article = articleService.getArticleById(artcId);
        if(article==null)
            throw new NotFoundException("101", "Article with id: "+ artcId + " not found");

        if(load==null) {
            return new SimpleArticleResponseImpl(article);
        }else{
            //Fetch the user record too
            System.out.println("----------------------------------------1");
            Object user = restTemplate.getForObject("http://user/api/v1/users/"+article.getCreatorUser(), Object.class);
            System.out.println("----------------------------------------3");
            return new DetailedArticleResponseImpl(article, user);
        }
    }

    @GetMapping
    public List<Article> getArticles() {
        System.out.println("----------------------------------- getArticles method");
        return articleService.getAllArticles();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createArticle(@RequestBody @Valid Article article) {
//        Article article1 = articleService.getArticleById(article.getArticleId());
//        if(article1!=null)
//            throw new NotFoundException("404", "Article not found");
        articleService.saveArticle(article);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateArticle(@RequestBody @Valid Article article) {
//        Article article1 = articleService.getArticleById(article.getArticleId());
//        if(article1==null)
//            throw new ConflictException("404", "Article already exist");
        articleService.saveArticle(article);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArticle(@PathVariable Integer id){
        if(id==null || id<1)
            throw new BadRequestException("100", "Invalid id");
        Article article = articleService.getArticleById(id);
        if(article==null)
            throw new NotFoundException("404","Article does not exist");
        articleService.deleteArticle(article);
    }

    @GetMapping("/user/{userId}")
    public List<Article> findArticlesByUser(@PathVariable Integer userId){
        if(userId == null | userId<1)
            throw new BadRequestException("100", "Invalid user id");
        return articleService.getAllArticlesByUser(userId);
    }
}
