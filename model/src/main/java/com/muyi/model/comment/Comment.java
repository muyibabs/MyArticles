package com.muyi.model.comment;

import java.time.LocalDateTime;

public class Comment {

    private Integer commentId;
    private Integer userId;
    private Integer articleId;
    private String comment;
    private LocalDateTime created;

    public Comment(Integer commentId, Integer userId, Integer articleId, String comment, LocalDateTime created) {
        this.commentId = commentId;
        this.userId = userId;
        this.articleId = articleId;
        this.comment = comment;
        this.created = created;
    }

    public Comment() {
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
