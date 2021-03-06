package com.articleSpringBoot.demo.service;

import java.util.List;

import com.articleSpringBoot.demo.entity.Article;



public interface IArticleService {
     List<Article> getAllArticles();
     Article getArticleById(int articleId);
     boolean createArticle(Article article);
     void updateArticle(Article article);
     void deleteArticle(int articleId);
}
