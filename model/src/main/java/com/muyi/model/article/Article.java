package com.muyi.model.article;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@ApiModel(description = "Class representing an article")
public class Article {

    private Integer articleId;

    @ApiModelProperty(example = "Hand washing", position = 1)
    @NotBlank(message = "Title cannot be blank")
    private String title;

    @ApiModelProperty(example = "Wash your hands with soap", position = 2)
    @NotBlank(message = "Content cannot be blank")
    private String content;

    @ApiModelProperty(example = "1", position = 3)
    @Positive(message = "User id is invalid")
    private Integer creatorUser;

    @ApiModelProperty(example = "2020-01-01T12:00:00", position = 4)
    @NotNull(message = "Created date-time cannot be null")
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
