package com.article.admin.repo;

import java.util.List;

import com.article.admin.entity.Article;

public interface UserRepo{
	List<Article> getUnblockedArticles();	
	List<Article> getBlockedArticles();	
	void blockArticle(int status, String id);
	void unBlockArticle(int status, String id);
}
