package com.muyi.article.service;

import com.muyi.article.dao.ArticleDao;
import com.muyi.model.article.Article;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
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
        Optional<com.muyi.model.article.entity.Article> article = articleDao.findById(id);
        if(article.isPresent())
            return modelMapper.map(article.get(), Article.class);
        return null;
    }

    @Override
    public List<Article> getAllArticles() {
        List<com.muyi.model.article.entity.Article> all = articleDao.findAll();
        if(!all.isEmpty())
            return all.stream().map(article -> modelMapper.map(article, Article.class)).collect(Collectors.toList());
        return null;
    }

    @Override
    public void saveArticle(Article article) {
        com.muyi.model.article.entity.Article article1 = modelMapper.map(article, com.muyi.model.article.entity.Article.class);
        articleDao.save(article1);
    }

    @Override
    public void deleteArticle(Article article) {
        com.muyi.model.article.entity.Article article1 = modelMapper.map(article, com.muyi.model.article.entity.Article.class);
        articleDao.delete(article1);
    }

    @Override
    public List<Article> getAllArticlesByUser(Integer userId) {
        List<com.muyi.model.article.entity.Article> articles = articleDao.findByCreatorUser(userId);
        return articles.stream().map(article -> modelMapper.map(article, Article.class)).collect(Collectors.toList());
    }
}
