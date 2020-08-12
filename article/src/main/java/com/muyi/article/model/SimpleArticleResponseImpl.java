package com.muyi.article.model;

import com.muyi.model.article.Article;

public class SimpleArticleResponseImpl implements ArticleResponse {

    Article article;

    public SimpleArticleResponseImpl(Article article) {
        this.article = article;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
