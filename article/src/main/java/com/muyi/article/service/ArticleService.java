package com.muyi.article.service;

import com.muyi.model.article.Article;

import java.util.List;

public interface ArticleService {

    Article getArticleById(Integer id);
    List<Article> getAllArticles();
    void saveArticle(Article article);
    void deleteArticle(Article article);
    List<Article> getAllArticlesByUser(Integer uId);
}
