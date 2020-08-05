package com.muyi.article.service;

import com.muyi.article.dao.ArticleDao;
import com.muyi.model.article.Article;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    private ModelMapper modelMapper;
    private ArticleDao articleDao;

    @Autowired
    public ArticleServiceImpl(ModelMapper modelMapper, ArticleDao articleDao) {
        this.modelMapper = modelMapper;
        this.articleDao = articleDao;
    }

    @Override
    public Article getArticleById(Integer id) {
        return null;
    }

    @Override
    public List<Article> getAllArticles() {
        return null;
    }

    @Override
    public void saveArticle(Article article) {

    }
}
