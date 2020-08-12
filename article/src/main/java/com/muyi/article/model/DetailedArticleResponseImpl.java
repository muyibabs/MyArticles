package com.muyi.article.model;

import com.muyi.model.article.Article;
import com.muyi.model.user.User;

public class DetailedArticleResponseImpl implements ArticleResponse {
    Article article;
    Object user;

    public DetailedArticleResponseImpl(Article article, Object user) {
        this.article = article;
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }
}
