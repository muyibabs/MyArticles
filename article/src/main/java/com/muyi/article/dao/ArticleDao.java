package com.muyi.article.dao;

import com.muyi.model.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao extends JpaRepository<Article, Integer> {
    List<Article> findByCreatorUser(Integer userId);
}
