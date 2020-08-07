package com.muyi.model.comment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@ApiModel(description = "Class representing Comments")
public class Comment {

    private Integer commentId;

    @ApiModelProperty(example = "1", position = 1)
    @Positive(message = "User ID must be a positive number")
    private Integer userId;

    @ApiModelProperty(example = "1", position = 2)
    @Positive(message = "Article ID must be a positive number")
    private Integer articleId;

    @ApiModelProperty(example = "This is a comment", position = 3)
    @NotBlank(message = "Comment cannot be blank")
    private String comment;

    @ApiModelProperty(example = "2020-01-01T12:00:00", position = 4)
    @NotNull(message = "Created date-time cannot be null")
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
