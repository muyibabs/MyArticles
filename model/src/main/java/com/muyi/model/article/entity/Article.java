package com.muyi.model.article.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer articleId;
    private String title;
    private String content;
    private Integer creatorUser;
    private LocalDateTime created;

    public Article() {
    }

    public Article(Integer articleId, String title, String content, Integer creatorUser, LocalDateTime created) {
        this.articleId = articleId;
        this.title = title;
        this.content = content;
        this.creatorUser = creatorUser;
        this.created = created;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(Integer creatorUser) {
        this.creatorUser = creatorUser;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
